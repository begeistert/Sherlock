package mx.brennen.sherlock.res

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import mx.brennen.sherlock.R
import mx.brennen.sherlock.res.misc.OnNoteLister


class PersonalAdapter(receivedList : ArrayList<Item>, private val onNoteListener: OnNoteLister) : RecyclerView.Adapter<PersonalAdapter.ViewItems>() {

    private val listOfItems = receivedList
    private var lastPosition = -1
    val cards : ArrayList<CardView> = ArrayList()
    val images : ArrayList<ImageView> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewItems {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu,null,false)
        return ViewItems(view,onNoteListener)

    }

    override fun getItemCount(): Int {

        return listOfItems.size

    }

    override fun onBindViewHolder(holder: ViewItems, position: Int) {

        holder.title.text = listOfItems.get(position).title
        holder.info.text = listOfItems.get(position).info
        holder.image.setImageResource(listOfItems.get(position).image)
        cards.add(holder.card)
        images.add(holder.image)
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
        val linearLayout : LinearLayout = itemView.findViewById(R.id.itemContainer)

        init {

            itemView.setOnClickListener(this)

        }


    }


}