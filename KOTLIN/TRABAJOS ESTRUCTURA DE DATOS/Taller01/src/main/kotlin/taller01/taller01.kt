/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 *
 * Unidad de Estudios: Estructura de Datos
 * Taller: 01
 * Fecha: 1 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller01

import kotlin.math.*
/*
Ejercicio 0: Una persona consume X coliras al dia y gasta Y calorias al dia. Si una caloria equivale a 100
gramos, escriba una funcion que hale cuantos gramos ha subido o bajado la persona despues de n dias
 */
fun ejercicio0 (cantidadgramos:Double, cantidagasto:Double,numerodias:Int): Double{
  return (cantidadgramos-cantidagasto)*100*numerodias
}

/* Ejercicio 01 */
fun ejercicio01(primerCorte: Double, segundoCorte: Double, pruebasObjetivas: Double): Double {
    return (primerCorte*0.4+segundoCorte*0.5+pruebasObjetivas*0.1)
}

/* Ejercicio 02 */
fun ejercicio02(metros: Double): Double {
    return ((metros*24.0)/100.0)*2
}

/* Ejercicio 03 */
fun ejercicio03(x: Double, y: Double): Double {
    return (Math.pow(x.toDouble(),2.0)+2*x*y+Math.pow(y.toDouble(),2.0))
}

/* Ejercicio 04 */
fun ejercicio04(base: Double, altura: Double): Pair<Double, Double> {//Esta es otra forma de solucionarlo pero sin las llaves=Pair(base*altura,2*base+2*altura)
    return Pair(base*altura,2*base+2*altura)
    /*
    Area = base*altura
    Perimetro=2*base+2*altura
    return Area to  
     */
}

/* Ejercicio 05 */
fun ejercicio05(gordos: Int, flacos: Int, numSillasBus: Int): Int {
    var s= gordos*2
    return ceil((s+flacos)/numSillasBus.toDouble()).toInt()
}

/* Ejercicio 06 */
fun ejercicio06(x: Double, alfa: Double): Double {
    return (x/sin(alfa))
}

/* Ejercicio 07 */
fun ejercicio07(sueldo: Double): Triple<Double, Double, Double> {
    val x=sueldo
    var arriendo= (sueldo*0.4)
    var comida= (sueldo*0.15)
    var total= x-(arriendo+comida)
    return Triple(arriendo,comida,total)
}

/* Ejercicio 08 */
fun ejercicio08(a: Double, b: Double): Triple<Double, Double, Double> {
    var p= b+(2.0*a)
    var h= sqrt(Math.pow(a.toDouble(),2.0)-(Math.pow(b.toDouble(),2.0)/4.0))
    var A= (b*sqrt(Math.pow(a.toDouble(),2.0)-(Math.pow(b.toDouble(),2.0)/4.0)))/2.0
    return Triple(p,h,A)
}

/* Ejercicio 09 */
fun ejercicio09(r: Double): Double {
    var A= PI*r.pow(2)
    return (A)
}

/* Ejercicio 10 */
fun ejercicio10(r: Double, R: Double): Double {
    return (PI*R.pow(2)-PI*r.pow(2))

}

/* Ejercicio 11 */
fun ejercicio11(n: Int, m: Int, k: Int): Pair<Int, Int> {
    var tempre= m*n
    var calif= tempre*k
    var horas= calif/60
    var minutos= calif%60
    return Pair(horas,minutos)

}

/* Ejercicio 12 */
fun ejercicio12(nombreHermano1: String, edadHermano1: Int,
                nombreHermano2: String, edadHermano2: Int,
                nombreHermano3: String, edadHermano3: Int): String {
    if (edadHermano1>edadHermano2 and edadHermano3){
        return (nombreHermano1)

    } else if (edadHermano2>edadHermano1 and edadHermano3){
        return (nombreHermano2)
    } else if (edadHermano3>edadHermano1 and edadHermano2){
        return (nombreHermano3)
    }

    return TODO("Provide the return value")
}

/* Ejercicio 13 */
fun ejercicio13(salario: Double): Pair<Double, Double> {
    TODO("Completar el ejercicio 13")
}

/* Ejercicio 14 */
fun ejercicio14(año: Int): Boolean {
    TODO("Completar el ejercicio 14")
}