package mx.brennen.sherlock.res

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import mx.brennen.sherlock.R
import mx.brennen.sherlock.res.misc.OnNoteLister


class PersonalAdapterInterpolation(private val receivedList : ArrayList<LinearLayout>) : RecyclerView.Adapter<PersonalAdapterInterpolation.ViewItems>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewItems {

        lastPosition++
        return ViewItems(receivedList[lastPosition])

    }

    override fun getItemCount(): Int {

        return receivedList.size

    }

    override fun onBindViewHolder(holder: ViewItems, position: Int) {

        holder.linearLayout = receivedList[position]

    }

    class ViewItems(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var linearLayout : LinearLayout = itemView.findViewById(R.id.itemInterpolation)


    }


}