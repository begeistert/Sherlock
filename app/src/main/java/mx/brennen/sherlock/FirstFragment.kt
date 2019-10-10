package mx.brennen.sherlock


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter

class FirstFragment : Fragment() {

    val itemList : ArrayList<Item> = ArrayList()
    lateinit var reciclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        reciclerView = List
        reciclerView.layoutManager = LinearLayoutManager(context)

        createList()

        val personalAdapter = PersonalAdapter(itemList)
        reciclerView.adapter = personalAdapter


        val list = arrayOf("Newton","Lagrange","Interpolacion","Lineal","Cuadratica")
        val stringAdapter = context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, list) }

        //List.adapter = stringAdapter!!

    }

    private fun createList() {

        itemList.add(Item("Interpolacion Lineal", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Interpolacion Cuadratica", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Newton", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Lagrange", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Gauss", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Interpolacion Lineal", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Interpolacion Cuadratica", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Newton", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("Lagrange", "Metodo de Interpolacion Lineal",R.drawable.calculo))
        itemList.add(Item("", "",R.drawable.empty))

    }

}
