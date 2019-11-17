package mx.brennen.sherlock


import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import katex.hourglass.`in`.mathlib.MathView
import kotlinx.android.synthetic.main.fragment_newton.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.TableDynamic
import mx.brennen.sherlock.res.misc.Iteracion
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onTouch
import org.jetbrains.anko.support.v4.toast
import java.math.RoundingMode
import java.text.DecimalFormat

@Suppress("UNCHECKED_CAST")
class NewtonFragment : Fragment() {

    private var variable = ' '
    private var width = 0f
    private var DESMOS_STATE = false
    private var iterations : ArrayList<Iteracion> = ArrayList()
    private var header = arrayOf("Iteracion", HtmlCompat.fromHtml("X<sub><small>n\n</small></sub>",
        HtmlCompat.FROM_HTML_MODE_LEGACY), HtmlCompat.fromHtml("F(X<sub><small>n\n</small></sub>)", HtmlCompat.FROM_HTML_MODE_LEGACY))
    private var rows: ArrayList<Array<String>> = ArrayList()
    private lateinit var df : DecimalFormat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newton, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val prefs = context!!.getSharedPreferences("Preferences", Context.MODE_PRIVATE)
        interpeter.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        desmos.settings.cacheMode = WebSettings.LOAD_NO_CACHE

        super.onViewCreated(view, savedInstanceState)

        doAsync {

            val size = Point()
            context!!.windowManager.defaultDisplay.getSize(size)
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

        context?.let { TypefaceUtil().overrideFont(it,"SERIF","fonts/arciform.otf") }

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.slide_top).setDuration(350)

        editvarInput.gravity = Gravity.CENTER

        editvarInput.addTextChangedListener {

            try {
                variable = editvarInput.text.toString().toCharArray()[0]
                textInputvar.isErrorEnabled = false

                if(editFunctionInput.text != null){

                    try {

                        if (CoreServices().isFunction(editFunctionInput.text.toString(), variable,1.0)){

                            editFunctionInput.setTextColor(Color.parseColor("#ffffff"))
                            text_input_layout_function.error = "Sintaxis Incorrrecta"
                            text_input_layout_function.isErrorEnabled = true

                        } else {

                            editFunctionInput.setTextColor(Color.parseColor("#ffffff"))
                            text_input_layout_function.isErrorEnabled = false
                            try {

                                interpeter.foregroundGravity = Gravity.CENTER
                                interpeter.setDisplayText("\$${CoreServices().mathml(editFunctionInput.text.toString())[1]}\$")

                            }catch (e: Exception){}

                        }

                    } catch (e : Exception){


                    }

                }
            }catch (e : java.lang.Exception){}

        }

        editFunctionInput.addTextChangedListener {

            if (editFunctionInput.text!!.isNotEmpty()){

                editFunctionInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cancel, 0)

            } else {

                editFunctionInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)

            }

            if (variable!=' '){

                try {

                    if (CoreServices().isFunction(editFunctionInput.text.toString(), variable,1.0)){

                        editFunctionInput.setTextColor(Color.parseColor("#ffffff"))
                        text_input_layout_function.error = "Sintaxis Incorrrecta"
                        text_input_layout_function.isErrorEnabled = true

                    } else {
                        editFunctionInput.setTextColor(Color.parseColor("#ffffff"))
                        text_input_layout_function.isErrorEnabled = false
                        try {

                            interpeter.foregroundGravity = Gravity.CENTER
                            interpeter.setDisplayText("\$${CoreServices().mathml(editFunctionInput.text.toString())[1]}\$")

                        }catch (e: Exception){}

                    }

                } catch (e : Exception){


                }

            } else {

                textInputvar.error = " "
                textInputvar.isErrorEnabled = true

            }

        }

        editFunctionInput.onRightDrawableClicked {

            it.text.clear()

        }

        edittoleranceInput.addTextChangedListener {

            if(edittoleranceInput.text!!.isNotEmpty()){

                edittoleranceInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cancel, 0)

            } else {

                edittoleranceInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)

            }

            when(textInputtolerance.hint.toString()){

                "Tolerancia -> 10^n" -> {

                    try {

                        if(CoreServices().tolerance("10^"+edittoleranceInput.text.toString())>0){

                            edittoleranceInput.textColor = Color.GREEN
                            textInputtolerance.isErrorEnabled = false

                        } else {

                            edittoleranceInput.textColor = Color.BLACK
                            textInputtolerance.error = "Solo inserta el valor de n"
                            textInputtolerance.isErrorEnabled = true

                        }

                    } catch (e : Exception){}

                }

            }

        }

        edittoleranceInput.onRightDrawableClicked {

            edittoleranceInput.text!!.clear()

        }

        calculate.onClick {

            val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            if(editAInput.text!!.toString() != "" && editBInput.text!!.toString() != ""
                && editFunctionInput.text!!.toString() != "" &&
                edittoleranceInput.text!!.toString() != ""
            ){

                val a = editAInput.text.toString().toDouble()
                val b = editBInput.text.toString().toDouble()

                iterations.clear()

                if (DESMOS_STATE){

                    desmos.evaluateJavascript("javascript:setMathModel(\'${CoreServices().simplify(editFunctionInput.text.toString())}\')",null)
                    if(!CoreServices().isFunction(editFunctionInput.text.toString(),'x',1.0)){

                        desmos.visibility = View.VISIBLE

                    }

                }

                when(aproachOptions.text.toString()){

                    "Limite de Iteraciones" -> {

                        try {

                            if(edittoleranceInput.text.toString().toInt()>1){

                                iterations = CoreServices().newtonRaphson(editFunctionInput.text.toString(),
                                    editvarInput.text.toString(), doubleArrayOf(a,b), CoreServices().tolerance("10^-1000"),
                                    edittoleranceInput.text.toString().toInt()).clone() as ArrayList<Iteracion>
                                textInputtolerance.isErrorEnabled = false

                            }

                        } catch (e : Exception){

                            textInputtolerance.error = "El limite de iteraciones no puede ser negativo"
                            textInputtolerance.isErrorEnabled = true

                        }

                    }

                    "Tolerancia" -> {

                        iterations = CoreServices().newtonRaphson(editFunctionInput.text.toString(),
                            editvarInput.text.toString(), doubleArrayOf(a,b), CoreServices().tolerance("10^"+edittoleranceInput.text.toString())
                            ,0).clone() as ArrayList<Iteracion>

                    }

                }

                createTable()

                toast("correcto")

            } else {

                toast("Comprueba tus datos")

            }

        }

        aproachOptions.onClick {

            val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            createSingleListDialog()

        }

        menicon.onClick {

            val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            (activity as HomeActivity).menu()

        }

        infoicon.onClick {

            val builderSymLegal = AlertDialog.Builder(context!!)
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

            mathView.setDisplayText("$${CoreServices().mathml(function.text.toString())[1]}$")

            dialogSymLegal.show()

        }

        var form = "#."
        for ( i in 1..prefs.getInt("Decimales",16)){

            form+="#"

        }

        df = DecimalFormat(form)
        df.roundingMode = RoundingMode.CEILING

    }

    private fun createTable(){

        Table.removeAllViewsInLayout()
        Table.removeAllViews()
        val tableDynamic = TableDynamic(Table, context,0)
        tableDynamic.addHeader(header)
        tableDynamic.addData(getIterationsFalsePosition())

    }

    private fun getIterationsFalsePosition() : ArrayList<Array<String>>? {

        rows.clear()

        var x0 = 0.0

        for(iteration in iterations){

            rows.add(arrayOf(iteration.number.toString(),df.format(iteration.xn).toString(),df.format(iteration.f).toString()))

            x0 = iteration.xn

        }

        val txt = "La Raiz es: $x0"

        txtRaiz.visibility = View.VISIBLE

        txtRaiz.text = txt

        return rows

    }

    @SuppressLint("ClickableViewAccessibility")
    fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
        this.setOnTouchListener { v, event ->
            var hasConsumed = false
            if (v is EditText) {
                if (event.x >= v.width - v.totalPaddingRight) {
                    if (event.action == MotionEvent.ACTION_UP) {
                        onClicked(this)
                    }
                    hasConsumed = true
                }
            }
            hasConsumed
        }
    }

    private fun createSingleListDialog() {

        val builder = this.context?.let { AlertDialog.Builder(it) }
        val items = arrayOf("Limite de Iteraciones","Tolerancia")

        val optionSelected = when(aproachOptions.text){

            "Limite de Iteraciones" -> 0

            "Tolerancia" -> 1

            else -> 0
        }

        builder!!.setTitle("Aproximar por").setSingleChoiceItems(items,optionSelected,(DialogInterface.OnClickListener { dialog, i ->

            aproachOptions.text = items[i]
            when(items[i]){

                "Limite de Iteraciones"->{

                    textInputtolerance.hint = "Limite de Iteraciones"
                    textInputtolerance.isErrorEnabled = false

                }

                "Tolerancia"->{

                    textInputtolerance.hint = "Tolerancia -> 10^n"
                    textInputtolerance.isErrorEnabled = false

                }

            }
            dialog.cancel()

        }))
        TypefaceUtil().overrideFont(builder.context,"SERIF","fonts/arciform.otf")
        builder.create()
        builder.show()

    }

}
