package mx.brennen.sherlock.res

import com.chaquo.python.Python

class Math {

    init {

    }

    fun tolerance(tolerance: String) : Double{

        var potence: Double = 0.toDouble()
        val notacion = tolerance.split("\\^".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val caracteres = notacion[1].toCharArray()
        if (caracteres[0] == '-') {

            var value = ""
            for (i in 1 until caracteres.size) {

                value += caracteres[i].toString()

            }

            try {

                potence = -value.toDouble()

            } catch (e: Exception) {



            }

        } else {

            val value = notacion[1]

            try {

                potence = value.toDouble()

            } catch (e : Exception){}

        }

        when {
            potence < 0 -> {

                var valor = 1.0
                var i = -1
                while (i >= potence) {

                    valor /= 10.0
                    i--

                }

                return valor

            }
            potence > 0 -> {

                var valor = 1.0
                var i = 1
                while (i <= potence) {

                    valor *= 10.0
                    i++

                }

                return valor

            }
            else -> println("La Tolerancia insertada no existe / no es un valor")
        }

        return 0.0

    }

    fun evaluate(function: String, variable: String, value : Double) : Double {

        return try {

            val py: Python = Python.getInstance()
            val mathFunctions = py.getModule("MathFunctions")
            val x = mathFunctions.callAttr("Symbol", variable)
            val functionParced = mathFunctions.callAttr("sympify",
                function).callAttr("subs", x,value) to Double
            val function2 = functionParced.first.repr()
            function2.toDouble()

        } catch (e : java.lang.Exception){

            java.lang.Double.NaN

        }

    }

    fun derive(function: String, respectTo : String) : String {

        return try{

            val py: Python = Python.getInstance()
            val mathFunctions = py.getModule("MathFunctions")
            val x = mathFunctions.callAttr("Symbol", respectTo)
            val derivative = mathFunctions.callAttr("diff",function,x) to String()
            derivative.first.repr()

        } catch(e : Exception) {

            ""

        }

    }

    fun simplify(function : String) : String{

        return try{

            val py: Python = Python.getInstance()
            val mathFunctions = py.getModule("MathFunctions")
            val derivative = mathFunctions.callAttr("simplify",function) to String()
            exponentiation(derivative.first.repr())

        }catch (e: Exception){

            function

        }

    }

    fun exponentiation(function: String) : String{

        val splitedFunction = function.split("**")
        var correctFunction = ""
        var i = 0
        for (part in splitedFunction){

            if (i == splitedFunction.size-1){

                correctFunction += part

            }else{

                correctFunction += "$part^"
                i++

            }

        }
        return correctFunction

    }

    fun solve(function: String, variable: String) : String{

        return try{

            val py: Python = Python.getInstance()
            val mathFunctions = py.getModule("MathFunctions")
            val x = mathFunctions.callAttr("Symbol", variable)
            val derivative = mathFunctions.callAttr("solve",function, x) to String()
            val fun1 = mathml(exponentiation(derivative.first.repr()))
            fun1[1]

        }catch (e: Exception){

            function

        }

    }

    fun mathml(function: String) : ArrayList<String>{

        val ecuations : ArrayList<String> = ArrayList()

        return try{

            val py: Python = Python.getInstance()
            val mathFunctions = py.getModule("MathFunctions")
            val functionSymPy = mathFunctions.callAttr("sympify", function)
            val mathml = mathFunctions.callAttr("latex",functionSymPy) to String()
            var repr = mathml.first.repr()
            var cutted = repr.split("\\\\")
            repr = ""
            var i = 0
            for (part in cutted){

                if (i == cutted.size-1){

                    repr += part

                }else{

                    repr += "$part\\"
                    i++

                }

            }
            cutted = repr.split("'")
            repr = ""
            for (part in cutted){

                repr += part

            }
            ecuations.apply {

                add(0,function)
                add(1,repr)

            }

        } catch (e : Exception){

            ecuations

        }

    }

    fun isFunction(function: String, variable: Char, value : Double) : Boolean {

        //Hibridacion Exitosa con Python
        return try {

            val py: Python = Python.getInstance()
            val mathFunctions = py.getModule("MathFunctions")
            val x = mathFunctions.callAttr("Symbol", variable)
            val functionParced = mathFunctions.callAttr("sympify",
                function).callAttr("subs", x,value) to String()
            functionParced.first.repr().toDouble()
            false

        } catch (e : java.lang.Exception){

            true

        }

    }

}
