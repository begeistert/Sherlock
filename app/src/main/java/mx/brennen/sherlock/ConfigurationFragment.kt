package mx.brennen.sherlock


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_configuration.*
import org.jetbrains.anko.support.v4.toast
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.net.Uri
import android.view.Window
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.sdk27.coroutines.onClick


class ConfigurationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuration, container, false)
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val prefs = context!!.getSharedPreferences("Preferences", MODE_PRIVATE)
        val editor = prefs.edit()

        value.text = prefs.getInt("Decimales",16).toString()
        seekBar.progress = prefs.getInt("Decimales",16)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                val decimals = i + 1
                editor.putInt("Decimales", decimals)
                editor.apply()
                value.text = "$decimals"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })

        about.onClick {

            val builder = context?.let { AlertDialog.Builder(it) }
            val v = layoutInflater.inflate(R.layout.fragment_about,null)
            val devBy = v.findViewById(R.id.devby) as TextView
            val legal = v.findViewById(R.id.legal) as TextView
            val version = v.findViewById(R.id.build) as TextView
            version.text = BuildConfig.VERSION_NAME

            builder!!.setView(v)
            TypefaceUtil().overrideFont(builder.context,"SERIF","fonts/arciform.otf")
            val dialog = builder.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)

            devBy.onClick {

                val builder1 = context?.let { AlertDialog.Builder(it) }

                dialog.cancel()
                builder1!!.setView(layoutInflater.inflate(R.layout.dialog_developed,null))
                TypefaceUtil().overrideFont(builder1.context,"SERIF","fonts/arciform.otf")
                val dialog1 = builder1.create()
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog1.window!!.decorView.setBackgroundResource(android.R.color.transparent)
                dialog1.show()

            }

            legal.onClick {

                dialog.cancel()

                val builder1 = context?.let { AlertDialog.Builder(it) }
                val v1 = layoutInflater.inflate(R.layout.legal_dialog,null)
                val fonturl = v1.findViewById(R.id.fontmatt) as TextView

                fonturl.onClick {

                    val uri = Uri.parse("https://www.behance.net/matt_ellis/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)

                }

                val iconurl = v1.findViewById(R.id.matematicas) as TextView

                iconurl.onClick {

                    val uri = Uri.parse("http://www.flaticon.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)

                }

                builder1!!.setView(v)
                TypefaceUtil().overrideFont(builder1.context,"SERIF","fonts/arciform.otf")
                val dialog1 = builder1.create()
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog1.window!!.decorView.setBackgroundResource(android.R.color.transparent)
                dialog1.show()

            }

            dialog.show()
        }

    }

}
