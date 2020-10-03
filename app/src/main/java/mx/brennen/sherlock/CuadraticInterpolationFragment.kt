package mx.brennen.sherlock

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.webkit.WebSettings
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import katex.hourglass.`in`.mathlib.MathView
import kotlinx.android.synthetic.main.fragment_cuadratic_interpolation.*
import mx.brennen.sherlock.res.Math
import mx.brennen.sherlock.res.NumericalMethods
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onTouch
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.windowManager

class CuadraticInterpolationFragment : Fragment() {

    private var width = 0f
    private var DESMOS_STATE = false
    private var FUNCTION = ""
    private val NM = NumericalMethods()
    private val math = Math()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuadratic_interpolation, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled", "InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        math_model.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        desmos.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        solutions.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        val prefs = requireContext().getSharedPreferences("Preferences", Context.MODE_PRIVATE)
        doAsync {

            val size = Point()
            requireContext().windowManager.defaultDisplay.getSize(size)
            val scale: Float = resources.displayMetrics.density
            width = ((size.x-(50*scale))/scale)
            DESMOS_STATE = prefs.getBoolean("desmosApi",false)

            desmos.onTouch { _, _ ->

                generalScroll.requestDisallowInterceptTouchEvent(true)

            }

            generalScroll.onTouch { _, _ ->

                generalScroll.requestDisallowInterceptTouchEvent(false)

            }

            if(DESMOS_STATE){

                uiThread {

                    if(desmos!=null){

                        desmos.settings.javaScriptEnabled = true
                        desmos.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                        val html = "<!DOCTYPE html>\n" +
                                "<html lang=\"en\">\n" +
                                "<head>\n" +
                                "    <meta charset=\"UTF-8\">\n" +
                                "    <title>Title</title>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "\n" +
                                "<script src=\"file:///android_asset/pages/calculator.js\"></script>\n" +
                                "  <div id=\"calculator\" style=\"width: ${width}px; height: 500px;\"></div>\n" +
                                "  <script>\n" +
                                "    var elt = document.getElementById('calculator');\n" +
                                "    var calculator = Desmos.GraphingCalculator(elt,{keyboard:false,expressions:false});\n" +
                                "    function setMathModel(model){\n" +
                                "\n" +
                                "      calculator.setExpression({id: 'function', latex: ('y=' + model)});\n" +
                                "\n" +
                                "    }" +
                                "    function setEvaluation(points){\n" +
                                "\n" +
                                "      calculator.setExpression({id: 'point', latex: (points)});\n" +
                                "\n" +
                                "    }" +
                                "  </script>\n" +
                                "\n" +
                                "</body>\n" +
                                "</html>\n"
                        desmos.loadDataWithBaseURL("file:///android_asset/pages/main.html", html, "text/html", "UTF-8", null)

                    }

                }

            }

        }

        calculate.onClick {

            try {

                val firstIntervals = DoubleArray(2).apply {

                    set(0,x1.text.toString().toDouble())
                    set(1,y1.text.toString().toDouble())

                }

                val secondIntervals = DoubleArray(2).apply {

                    set(0,x2.text.toString().toDouble())
                    set(1,y2.text.toString().toDouble())

                }

                val thirdIntervals = DoubleArray(2).apply {

                    set(0,x3.text.toString().toDouble())
                    set(1,y3.text.toString().toDouble())

                }

                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                doAsync {

                    val funtions = math.mathml(NM.quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals))
                    FUNCTION = funtions[0]

                    uiThread {

                        solutions.setDisplayText("$${math.solve(FUNCTION,"x")}$")
                        math_model.setDisplayText("$${funtions[1]}$")
                        rellay.visibility = View.VISIBLE
                        if (DESMOS_STATE){

                            desmos.evaluateJavascript("javascript:setMathModel(\'${FUNCTION}\')",null)
                            if(!math.isFunction(FUNCTION,'x',1.0)){

                                desmos.visibility = View.VISIBLE

                            }

                        }

                    }

                }

            }catch (e : Exception){

                toast("Comprueba tus datos de entrada")

            }

        }

        evaluate.onClick {

            try {

                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                val valueOf = math.evaluate(FUNCTION,"x",value.text.toString().toDouble())
                val mess = "El resultado de la evaluacion es: $valueOf"
                desmos.evaluateJavascript("javascript:setEvaluation(\'(" +
                        "${value.text.toString()},${valueOf})\')",null)
                valueofecuation.text = mess
                toast(mess)

            } catch (e : Exception){

                toast("Comprueba tu entrada")

            }

        }

        x_1.text = HtmlCompat.fromHtml("X<sub><small>1</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        y_1.text = HtmlCompat.fromHtml("F(X<sub><small>1</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)
        x_2.text = HtmlCompat.fromHtml("X<sub><small>2</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        y_2.text = HtmlCompat.fromHtml("F(X<sub><small>2</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)
        x_3.text = HtmlCompat.fromHtml("X<sub><small>3</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        y_3.text = HtmlCompat.fromHtml("F(X<sub><small>3</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)

        infoicon.onClick {

            val builderSymLegal = AlertDialog.Builder(requireContext())
            val viewSymLegal = layoutInflater.inflate(R.layout.fragment_intro_alpha,null)
            val areeButton = viewSymLegal.findViewById(R.id.aceptar) as TextView
            val mathView = viewSymLegal.findViewById(R.id.interpeter) as MathView
            val function = viewSymLegal.findViewById(R.id.cuar) as TextView

            mathView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
            builderSymLegal.setView(viewSymLegal)
            TypefaceUtil().overrideFont(builderSymLegal.context,"SERIF","fonts/arciform.otf")
            val dialogSymLegal = builderSymLegal.create()
            dialogSymLegal.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogSymLegal.window!!.decorView.setBackgroundResource(android.R.color.transparent)

            areeButton.onClick {

                dialogSymLegal.dismiss()
                val editor = prefs.edit()
                editor.putBoolean("firstTime",false)
                editor.apply()

            }

            mathView.setDisplayText("$${math.mathml(function.text.toString())[1]}$")

            dialogSymLegal.show()

        }

        menicon.onClick {

            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            (activity as HomeActivity).menu()

        }

    }

}
