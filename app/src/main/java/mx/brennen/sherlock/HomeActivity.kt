package mx.brennen.sherlock

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.internal.ApiExceptionUtil
import kotlinx.android.synthetic.main.activity_home.*
import mx.brennen.sherlock.res.Item
import mx.brennen.sherlock.res.PersonalAdapter
import mx.brennen.sherlock.res.misc.OnNoteLister
import mx.brennen.sherlock.res.misc.TypefaceUtil
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("UNCHECKED_CAST")
class HomeActivity : FragmentActivity() ,OnNoteLister, GoogleApiClient.OnConnectionFailedListener{

    override fun onConnectionFailed(p0: ConnectionResult) {

        toast("Conexion Fallida")

    }

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
        itemList.add(Item("Metodos de Intervalo", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
        itemList.add(Item("Metodos de Interpolación", "Metodo de Interpolacion Lineal",R.drawable.graph))
        itemList.add(Item("Métodos Iterativos", "Metodo de Interpolacion Lineal",R.drawable.bucle))
        itemList.add(Item("Diferenciacion Numérica", "Metodo de Interpolacion Lineal",R.drawable.partialderivative))
        itemList.add(Item("Integración Numérica", "Metodo de Interpolacion Lineal",R.drawable.integral))
        personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
        recyclerView.adapter = personalAdapter

        homeAct.openDrawer(GravityCompat.START)


    }

    override fun OnNoteListener(position: Int) {

        when(itemList[position].title){

            "Metodos de Intervalo" -> {

                views.clear()
                itemList.clear()
                itemList.add(Item("Metodo de Biseccion", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de Newton-Raphson", "Metodo de Interpolacion Lineal",R.drawable.graph))
                itemList.add(Item("Metodo de la Secante", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
                itemList.add(Item("Método de Falsa posicion", "Metodo de Interpolacion Lineal",R.drawable.bucle))
                itemList.add(Item("Metodo de Punto Fijo", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))

                personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
                recyclerView.adapter = personalAdapter

            }

            "Metodos de Interpolación" ->{

                views.clear()
                itemList.clear()
                itemList.add(Item("Metodo de Interpolacion Lineal", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de Interpolacion Cuadratica", "Metodo de Interpolacion Cuadratica",R.drawable.graph))
                itemList.add(Item("Metodo de Interpolacion de Newton","todo",R.drawable.square_brackets))
                itemList.add(Item("Metodo de Interpolacion de Lagrange", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
                itemList.add(Item("Metodo de Minimos Cuadrados", "Metodo de Interpolacion Cuadratica",R.drawable.graph))
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

            "Metodo de Valor Intermedio" -> {

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

    private lateinit var googleApiClient : GoogleSignInClient
    private lateinit var personalAdapter : PersonalAdapter
    private val SIGN_IN_CODE = 909
    private var itemList : ArrayList<Item> = ArrayList()
    private var views : ArrayList<ImageView> = ArrayList()
    private lateinit var recyclerView : RecyclerView

    @SuppressLint("CommitPrefEdits", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val prefs = baseContext.getSharedPreferences("Preferences", Context.MODE_PRIVATE)
        val account = GoogleSignIn.getLastSignedInAccount(applicationContext)

        if(prefs.getInt("Autorizado",0) == 0 || account == null){

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()

            googleApiClient = GoogleSignIn.getClient(applicationContext,gso)

            val intent = googleApiClient.signInIntent
            startActivityForResult(intent, SIGN_IN_CODE)

        }

        actionBar?.hide()

        doAsync {

            if(!Python.isStarted()) {

                Python.start(AndroidPlatform(applicationContext))
                //Precarga de librerias
                val py: Python = Python.getInstance()
                val mathFunctions = py.getModule("MathFunctions")

            }

        }

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

        itemList.add(Item("Metodos de Intervalo", "Metodo de Interpolacion Lineal",R.drawable.curlybrackets))
        itemList.add(Item("Metodos de Interpolación", "Metodo de Interpolacion Lineal",R.drawable.graph))
        itemList.add(Item("Métodos Iterativos", "Metodo de Interpolacion Lineal",R.drawable.bucle))
        itemList.add(Item("Diferenciacion Numérica", "Metodo de Interpolacion Lineal",R.drawable.partialderivative))
        itemList.add(Item("Integración Numérica", "Metodo de Interpolacion Lineal",R.drawable.integral))
        personalAdapter = PersonalAdapter(itemList,this, Typeface.createFromAsset(assets,"fonts/arciform.otf"))
        recyclerView.adapter = personalAdapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == SIGN_IN_CODE){

            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{

                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)

            }catch (e : Exception){

                finishAffinity()
                val mess = e.message
                toast(mess.toString())

            }

        }

    }

    @SuppressLint("CommitPrefEdits")
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {

        val fileMails = assets.open("AutorizedAccounts.txt")
        val bufferMails = BufferedReader(InputStreamReader(fileMails)).readLine()
        val mails = bufferMails.split("$")
        for(listedMail in mails){

            if(("$listedMail@gmail.com") == acct.email){

                toast("Autorizado")
                val prefs = baseContext.getSharedPreferences("Preferences", Context.MODE_PRIVATE)
                val editor = prefs.edit()
                editor.putInt("Autorizado",1)
                editor.apply()
                break

            }else{

                toast("No Autorizado")
                finishAffinity()

            }

        }

    }


}
