package mx.brennen.sherlock.res

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MyJavaScriptInterface internal constructor(private var mContext: Context) {

    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}