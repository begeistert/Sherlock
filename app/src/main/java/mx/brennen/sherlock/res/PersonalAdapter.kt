package mx.brennen.sherlock.res

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.brennen.sherlock.R

class PersonalAdapter(receivedList : ArrayList<Item>) : RecyclerView.Adapter<PersonalAdapter.ViewItems>() {

    private val listOfItems = receivedList

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewItems {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,null,false)
        return ViewItems(view)

    }

    override fun getItemCount(): Int {

        return listOfItems.size

    }

    override fun onBindViewHolder(holder: ViewItems, position: Int) {

        holder.title.text = listOfItems.get(position).title
        holder.info.text = listOfItems.get(position).info
        holder.image.setImageResource(listOfItems.get(position).image)

    }

    class ViewItems(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.itemTitle)
        val info : TextView = itemView.findViewById(R.id.itemContent)
        val image : ImageView = itemView.findViewById(R.id.itemImage)

    }


}