/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Geometría
 * Autor: Universidad EAN - 07 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller05

import kotlin.contracts.Returns
import kotlin.math.pow
import kotlin.math.sqrt


/**
 * Ejercicio 5
 */
fun ejercicio05(r: Double): Double {
    var cp= Circulo(r) // circulo peque
    var cg= Circulo(2*r)
    return cg.area()-cp.area()
}

/**
 * Ejercicio 6
 */
fun ejercicio06(u: Double): Double {
    var arRectangulo= Rectangulo(3*u,4*u)
    var arCuadrado= Cuadrado(2*u)
    var arTriangulo= Triangulo (3*u, 4*u)

    return (arRectangulo.area()+arCuadrado.area()+arTriangulo.area())
}

/**
 * Ejercicio 07
 */
fun ejercicio07(x: Double): Double {
    var arCirculo= Circulo(x/2)
    var aCuadrado= Cuadrado(x)
    return aCuadrado.area()-arCirculo.area()
}

/**
 * Ejercicio 08 - Hipotenusa
 */
fun ejercicio08(tri: Triangulo): Double {
    var hTriangulo= sqrt(tri.base.pow(2)+tri.altura.pow(2))
    return hTriangulo
}

/**
 * Ejercicio 09
 */
fun ejercicio09(a: Double, b: Double): Double {
    var aT = Triangulo(b,a)
    var hipotriangulo= ejercicio08(aT)
    var aC= Circulo(hipotriangulo/2)
    return aT.area()+aC.area()/2
}

/**
 * Ejercicio 10
 */
fun ejercicio10(r: Double): Double {
    var L= sqrt(r.pow(2)+r.pow(2))
    var aC= Cuadrado(L)
    var aCir= Circulo(r)
    return aCir.area()-aC.area()
}

/**
 * Ejercicio 11
 */
fun ejercicio11(r: Double, a: Double): Double {
    var aC= Circulo(r)
    var radio= r-a
    var aS= Circulo(radio)

    return (aC.area()/2) - (aS.area()/2)
}

/**
 * Ejercicio 12
 */
fun ejercicio12(x: Double, y: Double, z: Double): Double {
    var Cua= Rectangulo(y,x)
    var aTria = Triangulo(y,z-x)

    return Cua.area()+aTria.area()
}

/**
 * Ejercicio 13
 */
fun ejercicio13(a: Double, b: Double, c: Double, d: Double, e: Double): Double {
    var aT= Triangulo(e,d-c)
    var aP= Rectangulo(a,b)
    var aC= Rectangulo(e,c)

    return (aT.area()+aC.area())-aP.area()
}
