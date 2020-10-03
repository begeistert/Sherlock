package mx.brennen.sherlock.res

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import mx.brennen.sherlock.R
import mx.brennen.sherlock.res.misc.OnNoteLister


class PersonalAdapter(receivedList : ArrayList<Item>, private val onNoteListener: OnNoteLister, val typeface: Typeface) : RecyclerView.Adapter<PersonalAdapter.ViewItems>() {

    private val listOfItems = receivedList
    private var lastPosition = -1
    val images : ArrayList<ImageView> = ArrayList()

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewItems {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,null,false)
        return ViewItems(view,onNoteListener)

    }

    override fun getItemCount(): Int {

        return listOfItems.size

    }

    override fun onBindViewHolder(holder: ViewItems, position: Int) {

        holder.image.setImageResource(listOfItems[position].image)
        images.add(holder.image)
        holder.title.text = listOfItems[position].title
        holder.title.typeface = typeface
        holder.info.text = listOfItems[position].info
        holder.info.typeface = typeface
        setAnimation(holder.itemView, position)

    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            val animation = loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    class ViewItems(itemView: View, onNoteListener: OnNoteLister) : RecyclerView.ViewHolder(itemView) , View.OnClickListener {

        override fun onClick(p0: View?) {

            listener.OnNoteListener(adapterPosition)

        }

        val title : TextView = itemView.findViewById(R.id.itemTittle)
        val info : TextView = itemView.findViewById(R.id.itemContent)
        val image : ImageView = itemView.findViewById(R.id.itemImage)
        val card : CardView = itemView.findViewById(R.id.card)
        var listener = onNoteListener
        var linearLayout : LinearLayout = itemView.findViewById(R.id.itemContainer)

        init {

            itemView.setOnClickListener(this)

        }


    }


}