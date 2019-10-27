package mx.brennen.sherlock.res

import mx.brennen.sherlock.res.misc.Iteracion
import mx.brennen.sherlock.res.misc.IteracionPF
import mx.brennen.sherlock.res.misc.IteracionS
import mx.brennen.sherlock.res.misc.IteracionVI
import org.lsmp.djep.djep.DJep
import org.nfunk.jep.JEP
import org.nfunk.jep.ParseException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

@Suppress("NAME_SHADOWING")

class CoreServices{

    fun intermediateValue(function: String, `var`: String, Intervalos: DoubleArray, Tolerancia: Double, limit: Int) : ArrayList<IteracionVI>{

        val iterations = ArrayList<IteracionVI>()

        var fa1 = Intervalos[0]
        var fb = Intervalos[1]

        val pn1 = (Intervalos[0] + Intervalos[1]) / 2
        var iteration1 = 1

        while (true) {

            var fn1 = 0.0
            val iter = IteracionVI()

            if (iteration1 == 1) {

                iter.apply {

                    iteracion = iteration1
                    an = Intervalos[0]
                    bn = Intervalos[1]
                    pn = pn1
                    fn = (evaluate(function, `var`, pn1) * 1000000.0).roundToInt() / 1000000.0

                }

                iterations.add(iter)

                val fa = evaluate(function, `var`, Intervalos[0]) * fn1

                if (fa > 0) {

                    if (fn1 < 0) {

                        fn1 *= -1.0
                        if (fn1 < Tolerancia) {

                            break

                        }


                    } else {

                        if (fn1 < Tolerancia) {

                            break

                        }


                    }

                } else {

                    if (fn1 < 0) {

                        fn1 *= -1.0
                        if (fn1 < Tolerancia) {

                            break

                        } else {

                            fb = pn1

                        }

                    } else {

                        if (fn1 < Tolerancia) {

                            break

                        } else {

                            fb = pn1

                        }


                    }


                }

                iteration1++

            } else {

                iter.apply {

                    iteracion = iteration1
                    an = fa1
                    bn = fb
                    pn = ((fa1 + fb) / 2 * 1000000.0).roundToInt() / 1000000.0
                    fn = (evaluate(function, `var`, pn1) * 1000000.0).roundToInt() / 1000000.0

                }
                iterations.add(iter)

                val fa = evaluate(function, `var`, fa1) * fn1

                if (fa > 0) {

                    if (fn1 < 0) {

                        fn1 *= -1.0
                        if (fn1 < Tolerancia) {

                            break

                        } else {

                            fa1 = pn1

                        }

                    } else {

                        if (fn1 < Tolerancia) {

                            break

                        } else {

                            fa1 = pn1

                        }


                    }

                } else {

                    if (fn1 < 0) {

                        fn1 *= -1.0
                        if (fn1 < Tolerancia) {

                            break

                        } else {

                            fb = pn1

                        }

                    } else {

                        if (fn1 < Tolerancia) {

                            break

                        } else {

                            fb = pn1

                        }


                    }


                }
                iteration1++

            }

            if (limit>0){

                if (iteration1>limit){

                    break

                }

            }

        }
        
        return iterations

    }

    fun tolerance(tolerance: String) : Double{

        var potence: Double = 0.toDouble()
        val notacion = tolerance.split("\\^".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val caracteres = notacion[1].toCharArray()
        if (caracteres[0] == '-') {

            var value = ""
            for (i in 1 until caracteres.size) {

                value += Character.toString(caracteres[i])

            }

            try {

                potence = -java.lang.Double.valueOf(value)

            } catch (e: Exception) {



            }

        } else {

            val value = notacion[1]

            try {

                potence = Integer.parseInt(value).toDouble()

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

    fun secant(function: String, variable: String, intervals: DoubleArray, tolerance: Double, limit: Int) : ArrayList<IteracionS> {

        var x0: Double = 0.toDouble()
        var x: Double = 0.toDouble()
        var xx: Double
        var tr: Double
        var ex: Double
        var nIteration = 1
        val iterations: ArrayList<IteracionS> = ArrayList()

        val stop = false

        while (!stop) {

            val it = IteracionS()

            if (nIteration == 1) {

                x0 = intervals[0]
                x = intervals[1]
                val fxn1 = evaluate(function, variable, x)
                val fxn = evaluate(function, variable, x0)
                val xx0 = x - x0

                xx = ((x - fxn1 * xx0 / (fxn1 - fxn)) * 1000000.0).roundToInt() / 1000000.0

                it.apply {

                    iteracion = nIteration
                    setX(x)
                    setX0(x0)
                    setFxn(fxn)

                }

                iterations.add(it)

                ex = fxn

                if (ex < 0) {


                    tr = ex * -1.0

                    if (tr < tolerance) {

                        break

                    } else {

                        x0 = x
                        x = xx

                    }

                } else {

                    if (ex < tolerance) {

                        break

                    } else {

                        x0 = x
                        x = xx

                    }

                }

                nIteration++

            } else {

                val fxn1 = evaluate(function, variable, x)
                val fxn = evaluate(function, variable, x0)
                val xx0 = x - x0

                xx = ((x - fxn1 * xx0 / (fxn1 - fxn)) * 1000000.0).roundToInt() / 1000000.0

                it.apply {

                    iteracion = nIteration
                    setX(x)
                    setX0(x0)
                    setFxn(fxn)

                }

                iterations.add(it)

                ex = fxn

                if (ex < 0) {

                    tr = ex * -1.0

                    if (tr < tolerance) {

                        break

                    } else {

                        x0 = x
                        x = xx

                    }

                } else {

                    if (ex < tolerance) {

                        break

                    } else {

                        x0 = x
                        x = xx

                    }

                }

                nIteration++

            }

            if (limit>0){

                if (nIteration>limit){

                    break

                }

            }

        }

        return iterations

    }

    fun fixedPoint(function:String, variable :String, intervals:DoubleArray, tolerance:Double, limit: Int) : ArrayList<IteracionPF> {

        var x0: Double
        var xn: Double
        var cond: Double
        val listIteration = ArrayList<IteracionPF>()
        var niter = 0

        val derive = derive(function, variable)
        val x = "x-(($function)/($derive))"
        val resultFunction = x

        val iteration = IteracionPF()

        x0 = intervals[0]
        xn = evaluate(resultFunction, variable, x0)

        iteration.apply {

            ni = niter
            setValueOf((x0 * 1000000.0).roundToInt().toDouble() / 1000000.0)
            ev = ((xn) * 1000000.0).roundToInt().toDouble() / 1000000.0

        }

        listIteration.add(iteration)

        cond = x0 - xn

        if (cond < 0)
        {

            cond *= -1

        }

        while (cond > tolerance)
        {

            x0 = xn
            xn = evaluate(resultFunction, variable, x0)

            niter += 1
            val iterationNew = IteracionPF().apply {

                ni = niter
                setValueOf((x0 * 1000000.0).roundToInt().toDouble() / 1000000.0)
                ev = ((xn) * 1000000.0).roundToInt().toDouble() / 1000000.0

            }
            listIteration.add(iterationNew)

            cond = x0 - xn
            if (cond < 0)
            {

                cond *= -1

            }

            if (limit>0){

                if (niter>limit){

                    break

                }

            }


        }
        
        return listIteration

    }

    fun falsePosition(function:String, variable :String, intervals:DoubleArray, tolerance:Double, limit:Int) : ArrayList<IteracionVI> {

        var x0 = 0.0
        var x = 0.0
        var xx:Double
        var tr:Double
        var ex:Double
        var niteration = 1
        val iterations = ArrayList<IteracionVI>()

        val stop = false

        while (!stop) {

            val it = IteracionVI()

            if (niteration == 1) {

                x0 = intervals[0]
                x = intervals[1]
                val fxn1 = evaluate(function, variable, x)
                val fxn = evaluate(function, variable, x0)
                val xx0 = x - x0

                xx = ((x - fxn1 * xx0 / (fxn1 - fxn)) * 1000000.0).roundToInt() / 1000000.0
                val fpn = evaluate(function, variable, xx)

                it.apply {

                    iteracion = niteration
                    bn = x
                    an = x0
                    pn = xx
                    fn = fpn

                }

                val fn = evaluate(function, variable, x0) * fpn

                iterations.add(it)

                if (fn > 0){

                    ex = fpn

                    if (ex < 0) {

                        tr = ex * -1.0
                        if (tr < tolerance){

                            break
                        } else {

                            if (fpn > 0){

                                x = xx
                            } else if (fpn < 0) {

                                x0 = xx
                            }
                        }
                    } else {

                        if (ex < tolerance) {

                            break
                        } else {

                            if (fpn > 0) {

                                x = xx

                            } else if (fpn < 0) {

                                x0 = xx
                            }

                        }

                    }

                } else {

                    ex = fpn
                    if (ex < 0){

                        tr = ex * -1.0
                        if (tr < tolerance) {

                            break

                        } else {

                            if (fpn > 0) {

                                x = xx

                            } else if (fpn < 0) {

                                x0 = xx

                            }

                        }

                    } else {

                        if (ex < tolerance) {

                            break

                        } else {

                            if (fpn > 0) {

                                x = xx

                            } else if (fpn < 0) {

                                x0 = xx

                            }

                        }

                    }

                }

                niteration++

            } else {

                val fxn1 = evaluate(function, variable, x)
                val fxn = evaluate(function, variable, x0)
                val xx0 = x - x0

                xx = ((x - fxn1 * xx0 / (fxn1 - fxn)) * 1000000.0).roundToInt() / 1000000.0
                val fpn = evaluate(function, variable, xx)

                it.apply {

                    iteracion = niteration
                    bn = x
                    an = x0
                    pn = xx
                    fn = fpn

                }

                iterations.add(it)

                ex = fpn

                if (ex < 0) {

                    tr = ex * -1.0

                    if (tr < tolerance) {

                        break

                    } else {

                        if (fpn > 0) {

                            x = xx

                        } else if (fpn < 0) {

                            x0 = xx

                        }

                    }

                } else {

                    if (ex < tolerance) {

                        break

                    } else {

                        if (fpn > 0) {

                            x = xx

                        } else if (fpn < 0) {

                            x0 = xx

                        }

                    }

                }

                niteration++

                if (limit!=0){

                    if (niteration > limit) {

                        break

                    }

                } else {

                    if (niteration > 1000) {

                        break

                    }

                }

            }

        }
        
        return iterations

    }
    
    fun linearInterpolation(Intervals0: DoubleArray, Intervals1: DoubleArray) : String {

        val x0 = Intervals0[0]
        val fx0 = Intervals0[1]

        val x1 = Intervals1[0]
        val fx1 = Intervals1[1]

        val sup = fx1 - fx0
        val inf = x1 - x0

        val div = sup / inf

        return ("$fx0+$div*(x-$x0)")

    }

    fun newtonInterpolation(points: DoubleArray, evaluations: DoubleArray) : String {

        val fx0 = evaluations[0]
        var first: DoubleArray?
        var second: DoubleArray?

        val Auxn = ArrayList<DoubleArray>()

        var aux = ""

        var i = 0
        var se = 2

        while (i < evaluations.size) {

            if (i == 0) {

                first = DoubleArray(evaluations.size - 1)

                for (j in 1 until first.size + 1) {

                    first[j - 1] = (evaluations[j] - evaluations[j - 1]) / (points[j] - points[j - 1])

                }

                Auxn.add(first)
                first = null
                i++

            } else {

                first = Auxn[i - 1]
                second = DoubleArray(first.size - 1)

                for (j in 1 until second.size + 1) {

                    second[j - 1] = (first[j] - first[j - 1]) / (points[se + j - 1] - points[j - 1])

                }

                Auxn.add(second)
                first = null
                second = null
                i++
                se++

            }

        }

        var function = ""

        for (j in points.indices) {

            if (j == 0) {

                function = fx0.toString()

            } else {

                aux += "(x-" + points[j - 1].toString() + ")*"
                function += "+" + aux + "(" + Auxn[j - 1][0].toString() + ")"

            }

        }

        return function

    }

    fun lagrangeInterpolation(points: DoubleArray, evaluations: DoubleArray) : String{

        val fx = StringBuilder()
        var pos : Boolean
        var xi = 0
        var xj = 0

        for (i in points.indices) {

            fx.append("((")
            pos = i == points.size - 1

            for (j in points.indices) {

                if (i != j) {

                    if (points.size > 1) {

                        if (j == points.size - 1) {

                            fx.append("(x-").append(points[xj]).append(")")

                        } else if (j < points.size) {

                            if (pos && j == i - 1) {

                                fx.append("(x-").append(points[xj]).append(")")

                            } else {

                                fx.append("(x-").append(points[xj]).append(")*")

                            }

                        }

                    } else {

                        fx.append("(x-").append(points[xj]).append(")")

                    }

                } else {


                }

                xj++

            }

            xj = 0

            for (j in points.indices) {

                if (i != j) {

                    if (points.size > 2) {

                        if (xi == 0 || j == 0) {

                            fx.append(")/((").append(points[i].toString()).append("-").append(points[xj]).append(")*")

                        } else if (j == points.size - 1) {

                            fx.append("(").append(points[i].toString()).append("-").append(points[xj]).append(")")

                        } else {

                            if (pos && j == i - 1) {

                                fx.append("(").append(points[i].toString()).append("-").append(points[xj]).append(")")

                            } else {

                                fx.append("(").append(points[i].toString()).append("-").append(points[xj]).append(")*")

                            }

                        }

                    } else {

                        fx.append(")/((").append(points[i].toString()).append("-").append(points[xj]).append(")")

                    }

                    xi++

                } else {


                }

                xj++

            }

            if (i != points.size - 1) {

                fx.append("))*").append(evaluations[i].toString()).append("+")

            } else {

                fx.append("))*").append(evaluations[i].toString())

            }
            xi = 0
            xj = 0

        }

        return fx.toString()

    }

    fun quadraticInterpolation(Intervals0: DoubleArray, Intervals1: DoubleArray, Intervals2: DoubleArray) : String {

        val x0 = Intervals0[0]
        val b0 = Intervals0[1]

        val x1 = Intervals1[0]
        val fx1 = Intervals1[1]
        val b1 = (fx1 - b0) / (x1 - x0)

        val x2 = Intervals2[0]
        val fx2 = Intervals2[1]
        val aux0 = (fx2 - fx1) / (x2 - x1)
        val aux1 = (fx1 - b0) / (x1 - x0)
        val b2 = (aux0 - aux1) / (x2 - x0)

        return (b0.toString() + "+" + b1.toString() + "*(x-" + x0.toString() + ")+" + b2.toString() + "*(x-" +
                x0.toString() + ")*(x-" + x1.toString() + ")")
    }

    fun evaluate(function: String, variable: String, value : Double) : Double {

        return JEP().apply{

            addStandardConstants()
            addStandardFunctions()
            addVariable( variable, value)
            parseExpression(function)

        }.value

    }

    private fun derive(function: String, respectTo : String) : String {

        val derivative = DJep().apply {
            addStandardConstants()
            addStandardFunctions()
            addComplex()
            allowUndeclared = true
            allowAssignment = true
            implicitMul = true
            addStandardDiffRules()
        }

        try {

            return derivative.toString(derivative.simplify(derivative.differentiate(derivative.parse(function), respectTo)))

        } catch (e: ParseException) {}

        return ""

    }

    fun JacobiMethod(matrix: Array<DoubleArray>, xs: DoubleArray, useAproximations: Boolean) {

        val matrix: Array<DoubleArray>? = null
        val nx = 0
        val AuxXs = ArrayList<Double>()
        var xs: DoubleArray
        var oldxs: DoubleArray? = DoubleArray(nx)

        var iter = 0
        var cont = true

        while (cont) {

            xs = DoubleArray(nx)

            for (row in matrix!!.indices) {

                var div = 0.0

                for (column in matrix[row].indices) {

                    div = matrix[row][row] * -1

                    if (column != row) {

                        if (iter != 0) {

                            if (column != matrix[row].size - 1) {

                                xs[row] += matrix[row][column] * oldxs!![column] / div

                            } else {

                                xs[row] += matrix[row][column] / (div * -1)

                            }

                        } else {

                            if (column != matrix[row].size - 1) {

                                xs[row] += matrix[row][column] * xs[column] / div

                            } else {

                                xs[row] += matrix[row][column] / (div * -1)

                            }

                        }

                    }

                }

            }

            AuxXs.clear()
            for (i in xs.indices) {

                AuxXs.add(xs[i])

            }

            if (iter != 0) {

                var isNegative = false
                var isNegative1 = false
                val auxiliar = DoubleArray(nx)

                for (i in auxiliar.indices) {

                    auxiliar[i] = xs[i] - oldxs!![i]

                }

                val auxiliar2 = xs
                Arrays.sort(auxiliar)
                Arrays.sort(auxiliar2)

                for (i in auxiliar.indices) {

                    isNegative = auxiliar[i] < 0

                }

                for (i in auxiliar2.indices) {

                    isNegative1 = auxiliar2[i] < 0

                }

                var sup = 0.0
                var inf = 0.0

                sup = if (isNegative) {

                    auxiliar[0]

                } else {
                    auxiliar[auxiliar.size - 1]
                }

                inf = if (isNegative1) {

                    auxiliar2[0]

                } else {
                    auxiliar2[auxiliar2.size - 1]
                }

                val Condition = sup / inf

                if (Condition == 0.0) {

                    cont = false

                }

            }

            oldxs = DoubleArray(xs.size)
            for ((j, number) in AuxXs.withIndex()) {

                oldxs[j] = number

            }
            iter++

        }

        for (i in oldxs!!.indices) {

            println("El Valor de X" + (i + 1) + " es: " + oldxs[i])

        }
    }

    fun leastSquares(Xs: DoubleArray, Ys: DoubleArray) : Array<String>{

        val xy = DoubleArray(Xs.size)
        val x2 = DoubleArray(Xs.size)

        var sumx = 0.0
        var sumy = 0.0
        var sumxy = 0.0
        var sumx2 = 0.0

        for (i in Xs.indices) {

            xy[i] = Xs[i] * Ys[i]
            x2[i] = Xs[i] * Xs[i]

        }

        for (i in Xs.indices) {

            sumx += Xs[i]
            sumy += Ys[i]
            sumxy += xy[i]
            sumx2 += x2[i]

        }

        if (sumx < 0) {

            sumx *= -1

        }

        val m = (Xs.size * sumxy - sumx * sumy) / (Xs.size * sumx2 - sumx * sumx)
        val b = (sumy * sumx2 - sumx * sumxy) / (Xs.size * sumx2 - sumx * sumx)

        val fx = "$m*x+$b"
        val fy = "(y-$b)/($m)"

        return arrayOf(fx,fy)

    }

    fun newtonRaphson(function: String, variable : String, intervals: DoubleArray, tolerance: Double, limit: Int) : ArrayList<Iteracion>{

        var numberIteration = 1
        var xn: Double = 0.toDouble()
        var stop = false
        val iteration: ArrayList<Iteracion> = ArrayList()

        while (!stop) {

            val it = Iteracion()

            if (numberIteration == 1) {

                val x = (intervals[0] + intervals[1]) / 2

                val functionO = evaluate(function, variable, x)
                val functionD = evaluate(derive(function, variable), variable, x)

                xn = ((x - functionO / functionD) * 1000000.0).roundToInt().toDouble() / 1000000.0

                var functionR = evaluate(function, variable, xn)

                if (functionR < 0) {

                    functionR *= -1

                    if (tolerance > functionR) {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR
                        stop = true

                    } else {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR

                    }

                } else {

                    if (tolerance > functionR) {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR
                        stop = true

                    } else {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR

                    }
                }

                iteration.add(it)
                numberIteration = 2

            } else {

                val functionO = evaluate(function, variable, xn)
                val functionD = evaluate(derive(function, variable), variable, xn)

                xn = ((xn - functionO / functionD) * 1000000.0).roundToInt().toDouble() / 1000000.0

                var functionR = evaluate(function, variable, xn)

                if (functionR < 0) {

                    functionR *= -1
                    if (tolerance > functionR) {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR
                        stop = true

                    } else {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR

                    }

                } else {

                    if (tolerance > functionR) {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR
                        stop = true

                    } else {

                        it.number = numberIteration
                        it.setXn(xn)
                        it.f = functionR

                    }
                }

                iteration.add(it)
                numberIteration++

            }

            if (limit>0){

                if (numberIteration>limit){

                    break

                }

            }

        }

        return iteration

    }

    fun isFunction(function: String, variable: String, value : Double) : Boolean {

        return JEP().apply{

            addStandardConstants()
            addStandardFunctions()
            addVariable( variable, value)
            parseExpression(function)

        }.value.isNaN()

    }

    fun Taylor(function:String, variable :String, grade:Int, x0:Double, aproximation:Double) {

        var derivada:String?
        val evO:Double = (evaluate(function, variable, aproximation) * 1000000.0).roundToInt() / 1000000.0
        val evO2:Double = (evaluate(function, variable, x0) * 1000000.0).roundToInt() / 1000000.0
        var p = 0.0
        var e = 0.0

        var grado = grade

        grado -= 1
        val derivadas = arrayOfNulls<String>(grado + 3)
        derivadas[0] = function
        val values = DoubleArray(grado + 1)
        derivada = derive(function,variable)
        derivadas[1] = derivada

        for (i in 0 until grado + 1)
        {

            if (i < grado + 2)
            {

                values[i] = (derivada?.let { evaluate(it, variable, x0) }!! *(1000000.0)).roundToInt() / 1000000.0

            }
            derivada = derivada?.let { derive(it,variable) }
            derivadas[i + 2] = derivada

        }

        for (i in 0 until grado + 3)
        {

            if (i == 0)
            {

                p = evO2

            }
            else if (i == 1)
            {

                p += (values[i - 1] * (aproximation - x0) * 1000000.0).roundToInt() / 1000000.0

            }
            else if (i == grado + 2)
            {

                e = derivadas[i]?.let { evaluate(it, variable, (x0 + aproximation) / 2) }!! * Math.pow(aproximation - x0, i.toDouble()) / factorial(i)
                break

            }
            else
            {

                p += Math.round(values[i - 1] * Math.pow(aproximation - x0, i.toDouble()) / factorial(i) * 1000000.0) / 1000000.0

            }

        }

    }

    private fun factorial(Grad:Int):Double {

        var Factorial = Grad.toDouble()
        var Result = 1.0

        while (Factorial != 0.0)
        {

            Result = Result * Factorial
            Factorial--

        }

        return Result

    }

    private fun isCont(xs: DoubleArray, oldxs: DoubleArray, iter: Int, cont: Boolean,nx:Int): Boolean {
        var cont = cont
        if (iter != 0) {

            var isNegative = false
            var isNegative1 = false
            val auxiliar = DoubleArray(nx)

            for (i in auxiliar.indices) {

                auxiliar[i] = xs[i] - oldxs[i]

            }

            Arrays.sort(auxiliar)
            Arrays.sort(xs)

            for (i in auxiliar.indices) {

                isNegative = auxiliar[i] < 0

            }

            for (i in xs.indices) {

                isNegative1 = xs[i] < 0

            }

            val sup: Double
            val inf: Double

            sup = if (isNegative) {

                auxiliar[0]

            } else {
                auxiliar[auxiliar.size - 1]
            }

            inf = if (isNegative1) {

                xs[0]

            } else {
                xs[xs.size - 1]
            }

            val condition = sup / inf

            if (condition == 0.0) {

                cont = false

            }

        }
        return cont
    }

}
