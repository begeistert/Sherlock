package mx.brennen.sherlock

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_false.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.TableDynamic
import mx.brennen.sherlock.res.misc.IteracionVI
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.text.DecimalFormat

@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class FalseActivity : AppCompatActivity() {

    private var variable = ' '
    private lateinit var radioButton: RadioButton
    var iterations : ArrayList<IteracionVI> = ArrayList()
    private var header = arrayOf("Iteracion","Valor","Evaluacion")
    private var rows: ArrayList<Array<String>> = ArrayList()
    private lateinit var df : DecimalFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_false)

        editvarInput.gravity = Gravity.CENTER
        editvarInput.addTextChangedListener {

            variable = editvarInput.text.toString().toCharArray()[0]
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

            if (variable!=' '){

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

        calculate.onClick {

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

        }



    }

    fun checkButton(v : View) {

        val radioId = radioGroup.checkedRadioButtonId

        radioButton = findViewById(radioId)

        textInputtolerance.hint = radioButton.text.toString()

        if(radioButton.text.toString().equals("Tolerancia")){

            edittoleranceInput.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS

        } else {

            edittoleranceInput.inputType = InputType.TYPE_CLASS_NUMBER

        }

    }

    private fun createTable(){

        Table.removeAllViews()
        val tableDynamic = TableDynamic(Table, applicationContext, 0)
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

        txtRaiz.visibility = View.GONE

        txtRaiz.text = txt

        return rows

    }

    fun onMenuClick(view: View) {}

}
