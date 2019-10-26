package mx.brennen.sherlock


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_intervals.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter
import mx.brennen.sherlock.res.misc.OnNoteLister
import org.jetbrains.anko.support.v4.toast
import kotlin.collections.List

class IntervalsFragment : Fragment() , OnNoteLister {

    private var itemList : ArrayList<Item> = ArrayList()
    private lateinit var recyclerView : RecyclerView

    override fun OnNoteListener(position: Int) {

        when (itemList.get(position).title) {

            "Metodos de Intervalo" -> {


            }

            "Metodos de Interpolación" -> {



            }

            "Métodos Iterativos" -> {



            }

            "Diferenciacion Numérica" -> {}

            "Integración Numérica" -> {}

            "Método de Falsa posicion" -> {

                val intent = Intent(context, FalseActivity::class.java )
                startActivityForResult(intent,0)

            }

            "" -> {

                itemList.clear()
                createList()
                val personalAdapter = PersonalAdapter(itemList,this)
                recyclerView.adapter = personalAdapter

            }

        }

        toast(itemList.get(position).title)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intervals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        itemList.clear()

        recyclerView = List
        recyclerView.layoutManager = LinearLayoutManager(context)

        createList()

        val personalAdapter = PersonalAdapter(itemList,this)
        recyclerView.adapter = personalAdapter
    }

    private fun createList() {

        itemList.add(Item("Metodos de Intervalo", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
        itemList.add(Item("Metodos de Interpolación", "Metodo de Interpolacion Lineal",R.drawable.graph))
        itemList.add(Item("Métodos Iterativos", "Metodo de Interpolacion Lineal",R.drawable.bucle))
        itemList.add(Item("Diferenciacion Numérica", "Metodo de Interpolacion Lineal",R.drawable.partialderivative))
        itemList.add(Item("Integración Numérica", "Metodo de Interpolacion Lineal",R.drawable.integral))

    }

}
