package mx.brennen.sherlock

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter
import mx.brennen.sherlock.res.misc.OnNoteLister
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

@Suppress("UNCHECKED_CAST")
class HomeActivity : FragmentActivity() , OnNoteLister{

    override fun OnNoteListener(position: Int) {

        when(itemList.get(position).title){

            "Metodos de Intervalo" -> {

                itemList.clear()
                itemList.add(Item("Metodo Grafico", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de Valor Intermedio", "Metodo de Interpolacion Lineal",R.drawable.graph))
                itemList.add(Item("Método de Falsa posicion", "Metodo de Interpolacion Lineal",R.drawable.bucle))

                personalAdapter = PersonalAdapter(itemList,this)
                recyclerView.adapter = personalAdapter

            }

            "Método de Falsa posicion" -> {

                /*val extras = FragmentNavigatorExtras(
                    personalAdapter.images[position] to "itemImage" )*/
                homeAct.closeDrawers()
                val newFragment = FalseFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Falsa Posicion")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Valor Intermedio" -> {

                homeAct.closeDrawers()
                val newFragment = IntermediateFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

        }

        toast("Hola")

    }

    lateinit var personalAdapter : PersonalAdapter
    private var itemList : ArrayList<Item> = ArrayList()
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        actionBar?.hide()

        var newFragment = ConfigurationFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.replace(R.id.FragmentHost, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        itemList.clear()

        recyclerView = List
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        createList()

        personalAdapter = PersonalAdapter(itemList,this)
        recyclerView.adapter = personalAdapter

        val drawerToggle = object : ActionBarDrawerToggle(
            this,
            homeAct,0,0) {
            override fun onDrawerClosed(view: View) {

                itemList.clear()

                recyclerView = List
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                createList()

            }

            override fun onDrawerOpened(drawerView: View) {



            }
        }

        homeAct.addDrawerListener(drawerToggle)

        configuration.onClick {

            homeAct.closeDrawers()
            newFragment = ConfigurationFragment()
            transaction = supportFragmentManager.beginTransaction()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction.replace(R.id.FragmentHost, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }

    private fun createList() {

        itemList.add(Item("Metodos de Intervalo", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
        itemList.add(Item("Metodos de Interpolación", "Metodo de Interpolacion Lineal",R.drawable.graph))
        itemList.add(Item("Métodos Iterativos", "Metodo de Interpolacion Lineal",R.drawable.bucle))
        itemList.add(Item("Diferenciacion Numérica", "Metodo de Interpolacion Lineal",R.drawable.partialderivative))
        itemList.add(Item("Integración Numérica", "Metodo de Interpolacion Lineal",R.drawable.integral))
        personalAdapter = PersonalAdapter(itemList,this)
        recyclerView.adapter = personalAdapter

    }

}
