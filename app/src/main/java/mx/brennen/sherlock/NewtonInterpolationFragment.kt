package mx.brennen.sherlock


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_newton_interpolation.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.PersonalAdapterInterpolation
import org.jetbrains.anko.padding
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

class NewtonInterpolationFragment : Fragment() {

    private val X_FIELDS : ArrayList<TextInputEditText> = ArrayList()
    private val Y_FIELDS : ArrayList<TextInputEditText> = ArrayList()
    private val ITEMS : ArrayList<LinearLayout> = ArrayList()
    private lateinit var X_VALUES : DoubleArray
    private lateinit var Y_VALUES : DoubleArray

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_newton_interpolation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val prefs = context!!.getSharedPreferences("Preferences", Context.MODE_PRIVATE)

        cont.layoutManager = LinearLayoutManager(context)

        if(prefs.getBoolean("RealTime",false)){

            evaluate.visibility = View.GONE
            calculate.visibility = View.GONE
            aceptar.visibility = View.GONE

            pairs_number.addTextChangedListener{

                if(pairs_number.text.toString() != ""){

                    try {

                        generateFields(pairs_number.text.toString().toInt(),true)
                        cont.visibility = View.VISIBLE

                    }catch (e : Exception){

                        toast("Comprueba tu entrada")

                    }

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

                    X_VALUES = DoubleArray(X_FIELDS.size)
                    Y_VALUES = DoubleArray(Y_FIELDS.size)
                    var index = 0
                    for (X in X_FIELDS){

                        try {

                            X_VALUES[index] = X.text.toString().toDouble()
                            index++

                        }catch (e : Exception){

                            X_VALUES[index] = 0.0
                            index++

                        }

                    }

                    index = 0

                    for (Y in Y_FIELDS){

                        try {

                            Y_VALUES[index] = Y.text.toString().toDouble()
                            index++

                        }catch (e : Exception){

                            Y_VALUES[index] = 0.0
                            index++

                        }

                    }

                    math_model.text = CoreServices().newtonInterpolation(X_VALUES,Y_VALUES)
                    rellay.visibility = View.VISIBLE
                    val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                    toast(math_model.text)

                }catch (e : Exception){

                    toast("Comprueba tus datos de entrada")

                }

            }

            evaluate.onClick {

                try {

                    val valueOf = CoreServices().evaluate(math_model.text.toString(),"x",value.text.toString().toDouble())
                    val mess = "El resultado de la evaluacion es: $valueOf"
                    val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                    valueofecuation.text = mess
                    toast(mess)

                } catch (e : Exception){

                    toast("Comprueba tu entrada")

                }

            }

            aceptar.onClick {

                if(pairs_number.text.toString() != ""){

                    try{

                        generateFields(pairs_number.text.toString().toInt(), false)
                        val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(view.windowToken, 0)
                        cont.visibility = View.VISIBLE
                        calculate.visibility = View.VISIBLE

                    }catch (e : Exception){

                        toast("Comprueba tu entrada")

                    }

                }

            }

        }

        super.onViewCreated(view, savedInstanceState)

        menicon.onClick {

            (activity as HomeActivity).menu()

        }

    }

    private fun generateFields(size : Int, realTime : Boolean) {

        X_FIELDS.clear()
        Y_FIELDS.clear()
        ITEMS.clear()

        for ( i in 0 until size){

            val field = LayoutInflater.from(context).inflate(R.layout.item_interpolations,null) as LinearLayout
            field.padding = 5
            val xNumber = i+1

            field.findViewById<TextView>(R.id.X).text = HtmlCompat.fromHtml("X<sub><small>$xNumber</sub></small>", HtmlCompat.FROM_HTML_MODE_LEGACY)
            field.findViewById<TextView>(R.id.Y).text = HtmlCompat.fromHtml("F(X<sub><small>$xNumber</sub></small>)", HtmlCompat.FROM_HTML_MODE_LEGACY)

            Y_FIELDS.add(field.findViewById(R.id.y))
            X_FIELDS.add(field.findViewById(R.id.x))

            ITEMS.add(field)

            if(realTime){

                field.findViewById<TextInputEditText>(R.id.x).addTextChangedListener{

                    X_VALUES = DoubleArray(X_FIELDS.size)
                    Y_VALUES = DoubleArray(Y_FIELDS.size)
                    var index = 0
                    for (X in X_FIELDS){

                        try {

                            X_VALUES[index] = X.text.toString().toDouble()
                            index++

                        }catch (e : Exception){

                            X_VALUES[index] = 0.0
                            index++

                        }

                    }

                    index = 0

                    for (Y in Y_FIELDS){

                        try {

                            Y_VALUES[index] = Y.text.toString().toDouble()
                            index++

                        }catch (e : Exception){

                            Y_VALUES[index] = 0.0
                            index++

                        }

                    }

                    math_model.text = CoreServices().newtonInterpolation(X_VALUES,Y_VALUES)
                    rellay.visibility = View.VISIBLE

                }

                field.findViewById<TextInputEditText>(R.id.y).addTextChangedListener{

                    Y_VALUES = DoubleArray(Y_FIELDS.size)
                    X_VALUES = DoubleArray(X_FIELDS.size)
                    var index = 0
                    for (X in X_FIELDS){

                        try {

                            X_VALUES[index] = X.text.toString().toDouble()
                            index++

                        }catch (e : Exception){

                            X_VALUES[index] = 0.0
                            index++

                        }

                    }

                    index = 0

                    for (Y in Y_FIELDS){

                        try {

                            Y_VALUES[index] = Y.text.toString().toDouble()
                            index++

                        }catch (e : Exception){

                            Y_VALUES[index] = 0.0
                            index++

                        }

                    }

                    math_model.text = CoreServices().newtonInterpolation(X_VALUES,Y_VALUES)
                    rellay.visibility = View.VISIBLE

                }

            }

        }

        cont.adapter = PersonalAdapterInterpolation(ITEMS)

    }

}
