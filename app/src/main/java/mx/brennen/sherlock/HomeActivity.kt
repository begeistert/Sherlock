package mx.brennen.sherlock

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import kotlinx.android.synthetic.main.activity_home.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter
import mx.brennen.sherlock.res.misc.OnNoteLister
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.onClick

@Suppress("UNCHECKED_CAST")
class HomeActivity : FragmentActivity() ,OnNoteLister{

    fun menu() {

        val drawerToggle = object : ActionBarDrawerToggle(
            this,
            homeAct,0,0) {
            override fun onDrawerClosed(view: View) {

                itemList.clear()
                views.clear()

                recyclerView = List
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                createList()

            }

            override fun onDrawerOpened(drawerView: View) {



            }
        }

        homeAct.addDrawerListener(drawerToggle)

        itemList.clear()
        itemList.add(Item("Metodos Iterativos", "",R.drawable.curlybrackets))
        itemList.add(Item("Metodos de Interpolación", "",R.drawable.graph))
        personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
        recyclerView.adapter = personalAdapter

        homeAct.openDrawer(GravityCompat.START)


    }

    override fun OnNoteListener(position: Int) {

        when(itemList[position].title){

            "Metodos Iterativos" -> {

                views.clear()
                itemList.clear()
                itemList.add(Item("Metodo de Biseccion", "",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de Newton-Raphson", "",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de la Secante", "",R.drawable.curlybrackets))
                itemList.add(Item("Método de Falsa posicion", "",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de Punto Fijo", "",R.drawable.curlybrackets))

                personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
                recyclerView.adapter = personalAdapter

            }

            "Metodos de Interpolación" ->{

                views.clear()
                itemList.clear()
                itemList.add(Item("Metodo de Interpolacion Lineal", "",R.drawable.graph))
                itemList.add(Item("Metodo de Interpolacion Cuadratica", "",R.drawable.graph))
                itemList.add(Item("Metodo de Interpolacion de Newton","",R.drawable.graph))
                itemList.add(Item("Metodo de Interpolacion de Lagrange", "",R.drawable.graph))
                itemList.add(Item("Metodo de Minimos Cuadrados", "",R.drawable.graph))
                personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
                recyclerView.adapter = personalAdapter

            }

            "Método de Falsa posicion" -> {

                /*val extras = FragmentNavigatorExtras(
                    personalAdapter.images[position] to "itemImage" )*/
                homeAct.closeDrawers()
                views = personalAdapter.images
                val newFragment = FalseFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Falsa Posicion")
                transaction.addSharedElement(views[position],  "itemImage")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Biseccion" -> {

                homeAct.closeDrawers()
                val newFragment = IntermediateFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Newton-Raphson" -> {

                homeAct.closeDrawers()
                val newFragment = NewtonFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de la Secante" -> {

                homeAct.closeDrawers()
                val newFragment = SecantFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Punto Fijo" -> {

                homeAct.closeDrawers()
                val newFragment = FixedFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Interpolacion Lineal" ->{

                homeAct.closeDrawers()
                val newFragment = LinearInterpolationFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Interpolacion Cuadratica" -> {

                homeAct.closeDrawers()
                val newFragment = CuadraticInterpolationFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Interpolacion de Newton" -> {

                homeAct.closeDrawers()
                val newFragment = NewtonInterpolationFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Interpolacion de Lagrange" -> {

                homeAct.closeDrawers()
                val newFragment = LagrangeInterpolationFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

            "Metodo de Minimos Cuadrados" -> {

                homeAct.closeDrawers()
                val newFragment = LeastSquareFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                transaction.replace(R.id.FragmentHost, newFragment,"Intermedio")
                transaction.addToBackStack(null)
                transaction.commit()

            }

        }

    }

    private lateinit var personalAdapter : PersonalAdapter
    private var itemList : ArrayList<Item> = ArrayList()
    private var views : ArrayList<ImageView> = ArrayList()
    private lateinit var recyclerView : RecyclerView

    @SuppressLint("CommitPrefEdits", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState).doAsync {

            if(!Python.isStarted()) {

                Python.start(AndroidPlatform(applicationContext))
                //Precarga de librerias
                val python = Python.getInstance()
                python.getModule("MathFunctions").callAttr("print","Hello World")

            }

        }

        actionBar?.hide()

        setContentView(R.layout.activity_home)

        Handler().postDelayed({

            splash.animate().alpha(0.0f).apply {

                duration = 3000
                setListener(object : Animator.AnimatorListener {

                    override fun onAnimationStart(animation: Animator) {

                        FragmentHost.alpha = 0f
                        FragmentHost.visibility = View.VISIBLE
                        FragmentHost.animate().alpha(1.0f).duration = 4000

                    }

                    override fun onAnimationEnd(animation: Animator) {

                        menula.visibility = View.VISIBLE

                    }

                    override fun onAnimationCancel(animation: Animator) {}

                    override fun onAnimationRepeat(animation: Animator) {}
                })

            }


        },1000)

        TypefaceUtil().overrideFont(baseContext,"SERIF","fonts/arciform.otf")

        val newFragment = IntermediateFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.replace(R.id.FragmentHost, newFragment)
        transaction.commit()

        itemList.clear()

        recyclerView = List
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        createList()

        personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
        views = personalAdapter.images
        recyclerView.adapter = personalAdapter

        val drawerToggle = object : ActionBarDrawerToggle(
            this,
            homeAct,0,0) {
            override fun onDrawerClosed(view: View) {

                itemList.clear()
                views.clear()

                recyclerView = List
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                createList()

            }

            override fun onDrawerOpened(drawerView: View) {



            }
        }



        homeAct.addDrawerListener(drawerToggle)

        closemenu.onClick {

            homeAct.closeDrawers()

        }

        backmenubutton.onClick {

            itemList.clear()

            createList()

        }

        configuration.onClick {

            homeAct.closeDrawers()
            val fragment = ConfigurationFragment()
            transaction = supportFragmentManager.beginTransaction()
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction.replace(R.id.FragmentHost, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }

    private fun createList() {

        itemList.add(Item("Metodos de Iterativos", "",R.drawable.curlybrackets))
        itemList.add(Item("Metodos de Interpolación", "",R.drawable.graph))
        personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
        recyclerView.adapter = personalAdapter

    }
}
