package mx.brennen.sherlock

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_about.*
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.find


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        build.text = BuildConfig.VERSION_NAME

        devby.onClick {

            val builder = context?.let { AlertDialog.Builder(it) }

            builder!!.setView(layoutInflater.inflate(R.layout.dialog_developed,null))
            TypefaceUtil().overrideFont(builder.context,"SERIF","fonts/arciform.otf")
            val dialog = builder.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
            dialog.show()

        }

        legal.onClick {

            val builder = context?.let { AlertDialog.Builder(it) }
            val v = layoutInflater.inflate(R.layout.legal_dialog,null)
            val fonturl = v.findViewById(R.id.fontmatt) as TextView

            fonturl.onClick {

                val uri = Uri.parse("https://www.behance.net/matt_ellis/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)

            }

            val iconurl = v.findViewById(R.id.matematicas) as TextView

            iconurl.onClick {

                val uri = Uri.parse("http://www.flaticon.com/")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)

            }

            builder!!.setView(v)
            TypefaceUtil().overrideFont(builder.context,"SERIF","fonts/arciform.otf")
            val dialog = builder.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
            dialog.show()

        }

    }

}
