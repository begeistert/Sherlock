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
import androidx.navigation.Navigation
import org.jetbrains.anko.sdk27.coroutines.onClick


class ConfigurationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuration, container, false)
    }

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

            Navigation.findNavController(view).navigate(R.id.configurationFragment2toaboutFragment)

        }

    }

}
