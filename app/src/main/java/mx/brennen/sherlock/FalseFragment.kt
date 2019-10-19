package mx.brennen.sherlock


import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.widget.addTextChangedListener
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_false.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.TableDynamic
import mx.brennen.sherlock.res.misc.IteracionVI
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

@Suppress("UNCHECKED_CAST")
class FalseFragment : Fragment() {

    private var variable = ""
    private lateinit var radioButton: RadioButton
    var iterations : ArrayList<IteracionVI> = ArrayList()
    private var header = arrayOf("Iteracion","Valor","Evaluacion")
    private var rows: ArrayList<Array<String>> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_false, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.slide_top).setDuration(350)

    editvarInput.gravity = Gravity.CENTER

        editvarInput.addTextChangedListener {

            variable = editvarInput.text.toString()
            textInputvar.isErrorEnabled = false

            if(editFunctionInput.text != null){

                try {

                    if (CoreServices().isFunction(editFunctionInput.text.toString(), variable,1.0)){

                        editFunctionInput.setTextColor(Color.parseColor("#000000"))
                        text_input_layout_email.error = "Sintaxis Incorrrecta"
                        text_input_layout_email.isErrorEnabled = true

                    } else {

                        editFunctionInput.setTextColor(Color.parseColor("#008000"))
                        text_input_layout_email.isErrorEnabled = false

                    }

                } catch (e : Exception){


                }

            }

        }

        editFunctionInput.addTextChangedListener {

            if (variable!=""){

                try {

                    if (CoreServices().isFunction(editFunctionInput.text.toString(), variable,1.0)){

                        editFunctionInput.setTextColor(Color.parseColor("#000000"))
                        text_input_layout_email.error = "Sintaxis Incorrrecta"
                        text_input_layout_email.isErrorEnabled = true

                    } else {

                        editFunctionInput.setTextColor(Color.parseColor("#008000"))
                        text_input_layout_email.isErrorEnabled = false

                    }

                } catch (e : Exception){


                }

            } else {

                textInputvar.error = " "
                textInputvar.isErrorEnabled = true

            }

        }

        tolerance.onClick {

            radioButton = tolerance
            edittoleranceInput.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS ; InputType.TYPE_TEXT_VARIATION_NORMAL

        }

        limit.onClick {

            radioButton = limit
            edittoleranceInput.inputType = InputType.TYPE_CLASS_NUMBER

        }

        calculate.onClick {

            if(!editAInput.text!!.toString().equals("") && !editBInput.text!!.toString().equals("")
                && !editFunctionInput.text!!.toString().equals("") &&
                !edittoleranceInput.text!!.toString().equals("")){

                val a = editAInput.text.toString().toDouble()
                val b = editBInput.text.toString().toDouble()

                iterations.clear()

                when(radioButton.text.toString()){

                    "Limite de Iteraciones" -> {

                        iterations = CoreServices().falsePosition(editFunctionInput.text.toString(),
                            editvarInput.text.toString(), doubleArrayOf(a,b), CoreServices().tolerance("10^-3"),
                            edittoleranceInput.text.toString().toInt()).clone() as ArrayList<IteracionVI>


                    }

                    "Tolerancia" -> {

                        iterations = CoreServices().falsePosition(editFunctionInput.text.toString(),
                            editvarInput.text.toString(), doubleArrayOf(a,b), CoreServices().tolerance(edittoleranceInput.text.toString())
                            ,0).clone() as ArrayList<IteracionVI>

                    }

                }

                createTable()

                toast("correcto")

            } else {

                toast("Comprueba tus datos")

            }

        }

    }

    private fun createTable(){

        Table.removeAllViews()
        val tableDynamic = TableDynamic(Table, context)
        tableDynamic.addHeader(header)
        tableDynamic.addData(getIterationsFalsePosition())

    }

    private fun getIterationsFalsePosition() : ArrayList<Array<String>>? {

        var x0 = 0.0

        for(iteration in iterations){

            rows.add(arrayOf(iteration.iteracion.toString(),iteration.an.toString(),iteration.bn.toString()
                ,iteration.pn.toString(),iteration.fn.toString()))

            x0 = iteration.pn

        }

        val txt = "La Raiz es: $x0"

        txtRaiz.visibility = View.VISIBLE

        txtRaiz.text = txt

        return rows

    }

}
