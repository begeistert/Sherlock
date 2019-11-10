package mx.brennen.sherlock


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.fragment_cuadratic_interpolation.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class CuadraticInterpolationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuadratic_interpolation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val prefs = context!!.getSharedPreferences("Preferences", Context.MODE_PRIVATE)

        if(prefs.getInt("Autorizado",0) == 0){

            val builder = context!!.let { AlertDialog.Builder(it) }
            val v = layoutInflater.inflate(R.layout.fragment_intro_alpha,null)

            val agree = v.findViewById<TextView>(R.id.aceptar)

            builder.setView(v)
            TypefaceUtil().overrideFont(builder.context,"SERIF","fonts/arciform.otf")
            val dialog = builder.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)

            agree.onClick {

                dialog.dismiss()

            }

            dialog.show()

        }

        if(prefs.getBoolean("RealTime",false)){

            evaluate.visibility = View.GONE
            calculate.visibility = View.GONE

            x1.addTextChangedListener{

                try {

                    val firstIntervals = DoubleArray(2).apply {

                        if(x1.text.toString() != ""){
                            set(0,x1.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y1.text.toString() != ""){
                            set(1,y1.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    val secondIntervals = DoubleArray(2).apply {

                        if(x2.text.toString() != ""){
                            set(0,x2.text.toString().toDouble())
                        }else{
                            set(0,0.0)
                        }
                        if(y2.text.toString() != ""){
                            set(1,y2.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }
                    }

                    val thirdIntervals = DoubleArray(2).apply {

                        if(x3.text.toString() != ""){
                            set(0,x3.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y3.text.toString() != ""){
                            set(1,y3.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    if (!firstIntervals[0].isNaN()){

                        math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                        rellay.visibility = View.VISIBLE
                        if(value.text.toString() != ""){

                            try {

                                val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                                val mess = "El resultado de la evaluacion es: $valueOf"
                                valueofecuation.text = mess

                            } catch (e : Exception){


                            }

                        }

                    }

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            y1.addTextChangedListener{

                try {

                    val firstIntervals = DoubleArray(2).apply {

                        if(x1.text.toString() != ""){
                            set(0,x1.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y1.text.toString() != ""){
                            set(1,y1.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    val secondIntervals = DoubleArray(2).apply {

                        if(x2.text.toString() != ""){
                            set(0,x2.text.toString().toDouble())
                        }else{
                            set(0,0.0)
                        }
                        if(y2.text.toString() != ""){
                            set(1,y2.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }
                    }

                    val thirdIntervals = DoubleArray(2).apply {

                        if(x3.text.toString() != ""){
                            set(0,x3.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y3.text.toString() != ""){
                            set(1,y3.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    if (!firstIntervals[0].isNaN()){

                        math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                        rellay.visibility = View.VISIBLE
                        if(value.text.toString() != ""){

                            try {

                                val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                                val mess = "El resultado de la evaluacion es: $valueOf"
                                valueofecuation.text = mess

                            } catch (e : Exception){


                            }

                        }

                    }

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            x2.addTextChangedListener{

                try {

                    val firstIntervals = DoubleArray(2).apply {

                        if(x1.text.toString() != ""){
                            set(0,x1.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y1.text.toString() != ""){
                            set(1,y1.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    val secondIntervals = DoubleArray(2).apply {

                        if(x2.text.toString() != ""){
                            set(0,x2.text.toString().toDouble())
                        }else{
                            set(0,0.0)
                        }
                        if(y2.text.toString() != ""){
                            set(1,y2.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }
                    }

                    val thirdIntervals = DoubleArray(2).apply {

                        if(x3.text.toString() != ""){
                            set(0,x3.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y3.text.toString() != ""){
                            set(1,y3.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    if (!firstIntervals[0].isNaN()){

                        math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                        rellay.visibility = View.VISIBLE
                        if(value.text.toString() != ""){

                            try {

                                val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                                val mess = "El resultado de la evaluacion es: $valueOf"
                                valueofecuation.text = mess

                            } catch (e : Exception){


                            }

                        }

                    }

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            y2.addTextChangedListener{

                try {

                    val firstIntervals = DoubleArray(2).apply {

                        if(x1.text.toString() != ""){
                            set(0,x1.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y1.text.toString() != ""){
                            set(1,y1.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    val secondIntervals = DoubleArray(2).apply {

                        if(x2.text.toString() != ""){
                            set(0,x2.text.toString().toDouble())
                        }else{
                            set(0,0.0)
                        }
                        if(y2.text.toString() != ""){
                            set(1,y2.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }
                    }

                    val thirdIntervals = DoubleArray(2).apply {

                        if(x3.text.toString() != ""){
                            set(0,x3.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y3.text.toString() != ""){
                            set(1,y3.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    if (!firstIntervals[0].isNaN()){

                        math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                        rellay.visibility = View.VISIBLE
                        if(value.text.toString() != ""){

                            try {

                                val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                                val mess = "El resultado de la evaluacion es: $valueOf"
                                valueofecuation.text = mess

                            } catch (e : Exception){


                            }

                        }

                    }

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            x3.addTextChangedListener{

                try {

                    val firstIntervals = DoubleArray(2).apply {

                        if(x1.text.toString() != ""){
                            set(0,x1.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y1.text.toString() != ""){
                            set(1,y1.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    val secondIntervals = DoubleArray(2).apply {

                        if(x2.text.toString() != ""){
                            set(0,x2.text.toString().toDouble())
                        }else{
                            set(0,0.0)
                        }
                        if(y2.text.toString() != ""){
                            set(1,y2.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }
                    }

                    val thirdIntervals = DoubleArray(2).apply {

                        if(x3.text.toString() != ""){
                            set(0,x3.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y3.text.toString() != ""){
                            set(1,y3.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    if (!firstIntervals[0].isNaN()){

                        math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                        rellay.visibility = View.VISIBLE
                        if(value.text.toString() != ""){

                            try {

                                val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                                val mess = "El resultado de la evaluacion es: $valueOf"
                                valueofecuation.text = mess

                            } catch (e : Exception){


                            }

                        }

                    }

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            y3.addTextChangedListener{

                try {

                    val firstIntervals = DoubleArray(2).apply {

                        if(x1.text.toString() != ""){
                            set(0,x1.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y1.text.toString() != ""){
                            set(1,y1.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    val secondIntervals = DoubleArray(2).apply {

                        if(x2.text.toString() != ""){
                            set(0,x2.text.toString().toDouble())
                        }else{
                            set(0,0.0)
                        }
                        if(y2.text.toString() != ""){
                            set(1,y2.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }
                    }

                    val thirdIntervals = DoubleArray(2).apply {

                        if(x3.text.toString() != ""){
                            set(0,x3.text.toString().toDouble())
                        }else{
                            set(0, 0.0)
                        }
                        if(y3.text.toString() != ""){
                            set(1,y3.text.toString().toDouble())
                        }else{
                            set(1,0.0)
                        }

                    }

                    if (!firstIntervals[0].isNaN()){

                        math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                        rellay.visibility = View.VISIBLE
                        if(value.text.toString() != ""){

                            try {

                                val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                                val mess = "El resultado de la evaluacion es: $valueOf"
                                valueofecuation.text = mess

                            } catch (e : Exception){


                            }

                        }

                    }

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            value.addTextChangedListener {

                try {

                    val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                    val mess = "El resultado de la evaluacion es: $valueOf"
                    valueofecuation.text = mess
                    toast(mess)

                } catch (e : Exception){


                }

            }

        } else {

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

                    val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)

                    math_model.text = CoreServices().quadraticInterpolation(firstIntervals,secondIntervals,thirdIntervals)
                    rellay.visibility = View.VISIBLE
                    toast(math_model.text)

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            evaluate.onClick {

                try {

                    val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                    val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                    val mess = "El resultado de la evaluacion es: $valueOf"
                    valueofecuation.text = mess
                    toast(mess)

                } catch (e : Exception){

                    toast("Comprueba tu entrada")

                }

            }

        }

        super.onViewCreated(view, savedInstanceState)

        x_1.text = HtmlCompat.fromHtml("X<sub><small>1</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        y_1.text = HtmlCompat.fromHtml("F(X<sub><small>1</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)
        x_2.text = HtmlCompat.fromHtml("X<sub><small>2</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        y_2.text = HtmlCompat.fromHtml("F(X<sub><small>2</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)
        x_3.text = HtmlCompat.fromHtml("X<sub><small>3</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
        y_3.text = HtmlCompat.fromHtml("F(X<sub><small>3</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)

        menicon.onClick {

            (activity as HomeActivity).menu()

        }

    }

}
