package mx.brennen.sherlock


import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.InputType
import android.text.Spanned
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_false.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.TableDynamic
import mx.brennen.sherlock.res.misc.IteracionVI
import org.jetbrains.anko.image
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.tableLayout
import org.jetbrains.anko.textColor
import org.jetbrains.anko.toast
import java.math.RoundingMode
import java.text.DecimalFormat



@TargetApi(Build.VERSION_CODES.N)
@Suppress("UNCHECKED_CAST")
class FalseFragment : Fragment() {

    private var variable = ""
    private lateinit var radioButton: RadioButton
    var iterations : ArrayList<IteracionVI> = ArrayList()
    private var header = arrayOf("Iter.",Html.fromHtml("A<sub> i\n</sub>",
        Html.FROM_HTML_MODE_LEGACY),Html.fromHtml("B<sub> i\n</sub>",Html.FROM_HTML_MODE_LEGACY),
        Html.fromHtml("P<sub> i\n</sub>",Html.FROM_HTML_MODE_LEGACY),
        Html.fromHtml("F( P<sub> i\n</sub>)",Html.FROM_HTML_MODE_LEGACY))
    private var rows: ArrayList<Array<String>> = ArrayList()
    lateinit var df : DecimalFormat

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

        itemImage.image = context!!.getDrawable(R.drawable.bucle)

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

            if (editFunctionInput.text!!.isNotEmpty()){

                editFunctionInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cancel, 0)

            } else {

                editFunctionInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)

            }

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

        editFunctionInput.onRightDrawableClicked {

            it.text.clear()

        }

        edittoleranceInput.addTextChangedListener {

            if(edittoleranceInput.text!!.isNotEmpty()){

                edittoleranceInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cancel, 0)

            } else {

                edittoleranceInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)

            }

            val text = textInputtolerance.hint.toString()
            when(text){

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

            if(!editAInput.text!!.toString().equals("") && !editBInput.text!!.toString().equals("")
                && !editFunctionInput.text!!.toString().equals("") &&
                !edittoleranceInput.text!!.toString().equals("")){

                val a = editAInput.text.toString().toDouble()
                val b = editBInput.text.toString().toDouble()

                iterations.clear()

                when(radioButton.text.toString()){

                    "Limite de Iteraciones" -> {

                        iterations = CoreServices().falsePosition(editFunctionInput.text.toString(),
                            editvarInput.text.toString(), doubleArrayOf(a,b), CoreServices().tolerance("10^-1000"),
                            edittoleranceInput.text.toString().toInt()).clone() as ArrayList<IteracionVI>

                    }

                    "Tolerancia" -> {

                        iterations = CoreServices().falsePosition(editFunctionInput.text.toString(),
                            editvarInput.text.toString(), doubleArrayOf(a,b), CoreServices().tolerance("10^"+edittoleranceInput.text.toString())
                            ,0).clone() as ArrayList<IteracionVI>

                    }

                }

                createTable()

                toast("correcto")

            } else {

                toast("Comprueba tus datos")

            }

        }

        aproachOptions.onClick {

            createSingleListDialog()

        }

        val prefs = context!!.getSharedPreferences("Preferences", Context.MODE_PRIVATE)

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

            rows.add(arrayOf(iteration.iteracion.toString(),df.format(iteration.an).toString(),df.format(iteration.bn).toString()
                ,df.format(iteration.pn).toString(),df.format(iteration.fn).toString()))

            x0 = iteration.pn

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
        builder.create()
        builder.show()

    }

}
