/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 *
 * Unidad de Estudios: Estructura de Datos
 * Taller: 01
 * Fecha: 1 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
//dakdjaidasodjasopdoadoasodasiodaimdoamooidaiod
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
    return (Math.pow(x.toDouble(),2.0)+2*x*y+y.pow(2.0))
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
    return ceil((s+flacos)/numSillasBus.toDouble()).toInt()//El ceil lo que hace es redondear el numero pero en el siguiente numero tienes que convertirlo en double
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
    return (ejercicio09(R)- ejercicio09(r))

}

/* Ejercicio 11 */
fun ejercicio11(n: Int, m: Int, k: Int): Pair<Int, Int> {
    var calif= m*n*k
    var horas= calif/60
    var minutos= calif%60 //El modulo es el residuo de la division
    return Pair(horas,minutos)

}

/* Ejercicio 12 */
fun ejercicio12(nombreHermano1: String, edadHermano1: Int,
                nombreHermano2: String, edadHermano2: Int,
                nombreHermano3: String, edadHermano3: Int): String {
   var nombress=""
    if (edadHermano1>edadHermano2 && edadHermano1>edadHermano3){
         nombress=nombreHermano1
    }
    if (edadHermano2>edadHermano1 && edadHermano2>edadHermano3){
        nombress=nombreHermano2
    }
    if (edadHermano3>edadHermano1 && edadHermano2>edadHermano2){
        nombress=nombreHermano3
    }
    
    return (nombress)
}

/* Ejercicio 13 */
fun ejercicio13(salario: Double): Pair<Double, Double> {
    var aumento:Double=0.0
    var salarionuevo:Double=0.0
    if (salario<800_000){
        aumento=salario*0.1
        salarionuevo=aumento+salario
    } else if (salario>800_000 && salario<1200_000){
        aumento=salario*0.08
        salarionuevo=aumento+salario
    }else if (salario>1200_000){
        aumento=salario*0.05
        salarionuevo=aumento+salario
    }
    return Pair(aumento,salarionuevo)

}

/* Ejercicio 14 */
fun ejercicio14(año: Int): Boolean {
    if ((año%4==0)&&(año%100!=0||año%400==0)){
      return true
    }else {
        return false
    }
}
