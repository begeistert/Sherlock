package mx.brennen.sherlock


import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_interval_options.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter
import mx.brennen.sherlock.res.misc.OnNoteLister

class IntervalOptionsFragment : Fragment() , OnNoteLister {

    lateinit var personalAdapter : PersonalAdapter

    override fun OnNoteListener(position: Int) {

        when(itemList.get(position).title){

            "Método de Falsa posicion" -> {


            }

        }

    }

    private var itemList : ArrayList<Item> = ArrayList()
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interval_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        recyclerView = List
        recyclerView.layoutManager = LinearLayoutManager(context)

        itemList.clear()
        itemList.add(Item("Metodo Grafico", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
        itemList.add(Item("Metodo de Bisección", "Metodo de Interpolacion Lineal",R.drawable.graph))
        itemList.add(Item("Método de Falsa posicion", "Metodo de Interpolacion Lineal",R.drawable.bucle))

        personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(context!!.assets,"fonts/arciform.otf"))
        recyclerView.adapter = personalAdapter

    }

}
