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

import kotlin.math.pow
import kotlin.math.sqrt


/**
 * Ejercicio 5
 */
fun ejercicio05(r: Double): Double {
    var cp:Circulo=Circulo(r)
    var cg:Circulo= Circulo(2*r)
    return cg.area()-cp.area()

}

/**
 * Ejercicio 6
 */
fun ejercicio06(u: Double): Double {
    var t=Triangulo(4*u,3*u)
    var ra=Rectangulo(3*u,2*u)
    var c=Cuadrado(2*u)
    return t.area()+2*ra.area()+c.area()
}

/**
 * Ejercicio 07
 */
fun ejercicio07(x: Double): Double {
    var c=Cuadrado(x)
    var cl=Circulo(x/2)
    return c.area()-cl.area()
}

/**
 * Ejercicio 08 - Hipotenusa
 */
fun ejercicio08(tri: Triangulo): Double {
    var hipotenusa= sqrt(tri.altura.pow(2)+tri.base.pow(2))
    return hipotenusa
}

/**
 * Ejercicio 09
 */
fun ejercicio09(a: Double, b: Double): Double {
    var t=Triangulo(b,a)
    var hipotenusa= sqrt(t.altura.pow(2)+t.base.pow(2))
    var c=Circulo(hipotenusa/2)
    return t.area()+c.area()/2
}

/**
 * Ejercicio 10
 */
fun ejercicio10(r: Double): Double {
    var lado= sqrt(r.pow(2)+r.pow(2))
    var cd=Cuadrado(lado)
    var c=Circulo(r)
    return c.area()-cd.area()
}

/**
 * Ejercicio 11
 */
fun ejercicio11(r: Double, a: Double): Double {
    var cg= Circulo(r)
    var radiop=r-a
    var cp=Circulo(radiop)
    return cg.area()/2-cp.area()/2
}

/**
 * Ejercicio 12
 */
fun ejercicio12(x: Double, y: Double, z: Double): Double {
    var rc=Rectangulo(x,y)
    var tr=Triangulo(y,z-x)
    return rc.area()+tr.area()

}

/**
 * Ejercicio 13
 */
fun ejercicio13(a: Double, b: Double, c: Double, d: Double, e: Double): Double {
    var Tc=Triangulo(e,d-c)
    var Casa=Rectangulo(e,c)
    var Puerta=Rectangulo(a,b)
   return (Casa.area()-Puerta.area())+Tc.area()
}
