package mx.brennen.sherlock


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.android.synthetic.main.fragment_linear_interpolation.*
import mx.brennen.sherlock.res.CoreServices
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class LinearInterpolationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear_interpolation, container, false)
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

        super.onViewCreated(view, savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            textInputA.hint = Html.fromHtml("x<sub>1</sub>",Html.FROM_HTML_MODE_LEGACY)

        }else{

            textInputA.hint = Html.fromHtml("x<sub>1</sub>")

        }

        menicon.onClick {

            (activity as HomeActivity).menu()

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

                val mathModel = CoreServices().linearInterpolation(firstIntervals,secondIntervals)
                toast(mathModel)

            }catch (e : Exception){

                toast("Comprueba tus datos de entrada")

            }

        }

    }

}
