package mx.brennen.sherlock


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter
import mx.brennen.sherlock.res.misc.OnNoteLister


class FirstFragment : Fragment(), OnNoteLister {

    override fun OnNoteListener(position: Int) {

        when (position) {

            1 -> {

                val fragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.apply {

                    replace(R.id.hostFragment, NewtonFragment())

                }
                fragmentTransaction.commit()


            }

        }

    }

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

        val personalAdapter = PersonalAdapter(itemList,this)
        reciclerView.adapter = personalAdapter
        val list = arrayOf("Newton","Lagrange","Interpolacion","Lineal","Cuadratica")
        val stringAdapter = context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, list) }

        //List.adapter = stringAdapter!!

    }

    private fun createList() {

        itemList.add(Item("Interpolacion Lineal", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Interpolacion Cuadratica", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Newton", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Lagrange", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Gauss", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Interpolacion Lineal", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Interpolacion Cuadratica", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Newton", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("Lagrange", "Metodo de Interpolacion Lineal",R.drawable.calculo,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))
        itemList.add(Item("", "",R.drawable.empty,View.OnClickListener {

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.apply {

                replace(R.id.hostFragment, NewtonFragment())

            }
            fragmentTransaction.commit()


        }))

    }

}
