package taller19

import ean.colecciones.Lista
import kotlin.math.pow
import kotlin.math.sqrt


// Esta clase guarda la información de un producto de una tienda
data class Producto(val codigo: Int, val nombre: String, val cantidad: Int, val precio: Int)

// Esta clase guarda la información de un departamento del país
data class Departamento(
    val nombre: String,
    val poblacion: Int,
    val superficie: Double,
    val densidad: Double,
    val IDH: Double,
    val añoCreacion: Int)

// Esta clase guarda la información de un municipio del pais
data class Municipio(
    val codigo: Int,
    val nombre: String,
    val departamento: String,
    val poblacionUrbana: Int,
    val poblacionRural: Int,
    val esCapital: Boolean
)

// Esta clase guarda la información de un rectángulo
data class Rectangulo(val base: Double, val altura: Double) {
    // Hallar el área del rectangulo
    fun area(): Double = base * altura
}

// Esta clase guarda la información de un triángulo
data class Triangulo(val id: Int,
                     val lado1: Double,
                     val lado2: Double,
                     val lado3: Double)

//-------------------------------------------------------------------
// Operaciones con la clase Departamento
//-------------------------------------------------------------------

/**
 * Obtener el nombre del departamento más antiguo de toda la lista.
 * Si la lista está vacía, retorne null
 */
fun metodo6(dptos: Lista<Departamento>): String? {
    val anti = dptos.encontrarMenor { it.añoCreacion }
    val tras = anti?.nombre
    return tras
}
/**
 * Retorna el  departamento que tiene la superficie más grande
 * pero con una población superior a la población que se pasa
 * como parámetro.
 */
fun metodo7(dptos: Lista<Departamento>, poblacion: Int): Departamento? {
    val filt = dptos.filtrar { it.poblacion>poblacion }
    val tranS = filt.encontrarMayor { it.superficie }
    return tranS
}

/**
 * Retorne la lista de los nombres de los departamentos creados
 * en el siglo XX y que tenga un IDH entre 0.85 y 0.95
 */
fun metodo8(dptos: Lista<Departamento>): Lista<String> {
    val enco = dptos.filtrar{ it.añoCreacion in 1900 until 1999 && it.IDH in 0.85 .. 0.95  }
    val dep  = enco.transformar { it.nombre }
    return dep
}
/**
 * Retorne el porcentaje de departamentos de la lista cuya densidad
 * esté por debajo del valor que se pasa como parámetro
 */
fun metodo9(deptos: Lista<Departamento>, valor: Double): Double {
    val filtro = deptos.filtrar { it.densidad<valor }
    return (filtro.tam.toDouble()/deptos.tam)*100
}
/**
 * Retorne el promedio de superficie de los departamentos de la lista
 * cuya poblacion sea superior a la población del departamento con menor
 * IDH de toda la lista
 */
fun metodo10(deptos: Lista<Departamento>): Double {
    val menoridh = deptos.encontrarMenor { it.IDH }
    val menor = menoridh?.poblacion
    val filtro = deptos.filtrar { it.poblacion> menor!! }
    val total =   filtro.sumar (fun (d:Departamento):Double=d.superficie)
    return total/filtro.tam
}

//-------------------------------------------------------------------
// Operaciones con la clase Municipio
//-------------------------------------------------------------------
/**
 * Determinar y retornar cuántos municipios de la lista son capitales
 */
fun metodo11(muns: Lista<Municipio>): Int {
   return muns.contar { it.esCapital }
}
/**
 * Determinar el nombre del municipio que no es capital y que pertenece al
 * departamento que se recibe como parámetro y que tiene la población urbana
 * más grande
 */
fun metodo12(m: Lista<Municipio>, depto: String): String {
    val dept = m.filtrar { it.departamento == depto && !it.esCapital }
    val nomb = dept.encontrarMayor { it.poblacionUrbana }!!.nombre
    return nomb
}

/**
 * Retornar el promedio de la población total (suma de la población rural y población urbana)
 * de aquellos municipios de la lista que pertenecen al departamento que se pasa
 * como parámetro y cuyo código sea múltiplo de 3 o de 5
 */
fun metodo13(municipios: Lista<Municipio>, departamento: String): Double {
    val filtro = municipios.filtrar { it.departamento == departamento && (it.codigo %3 ==0 || it.codigo%5==0) }
    val total =   filtro.sumar (fun (m:Municipio):Int=m.poblacionRural+m.poblacionUrbana)
    return total/filtro.tam.toDouble()

}

/**
 * Retorne el nombre del primer municipio que inicia con J en toda la lista
 */
fun metodo14(muns: Lista<Municipio>): String {
    val fil  = muns.encontrarElPrimeroQueCumple { it.nombre.startsWith("J") }
    return fil!!.nombre
}


/**
 * Retorne cuantos municipios de la lista que tienen un código
 * de 4 dígitos poseen una poblacion rural superior a la población
 * urbana
 */
fun metodo15(muns: Lista<Municipio>): Int {
    return muns.contar { it.codigo in 1000..9999 && it.poblacionRural > it.poblacionUrbana }

}

//-------------------------------------------------------------------
// Operaciones con la clase Producto
//-------------------------------------------------------------------

/**
 * Obtener el nombre de todos los productos cuyo código es par
 */
fun metodo1(productos: Lista<Producto>): Lista<String> {
    val lista1 = productos.filtrar { it.codigo % 2 == 0 }
    return lista1.transformar { it.nombre }
}

/**
 * Obtener cuántos productos tienen un precio inferior al producto
 * cuyo código se pasa como parámetro
 */
fun metodo2(productos: Lista<Producto>, codProducto: Int): Int {
    val prod = productos.encontrarElPrimeroQueCumple { it.codigo==codProducto }
    return productos.filtrar { it.precio<prod!!.precio }.tam
}

/**
 * Obtener una lista con los códigos de los productos cuya cantidad sea
 * superior a la cantidad mínima que se pasa como parámetro y cuyo precio
 * esté entre mil y diez mil pesos.
 *
 */
fun metodo3(productos: Lista<Producto>, cantidadMinima: Int): Lista<Int> {
    var lista = productos.filtrar { it.cantidad > cantidadMinima && it.precio in 1000..10000 }
    return lista.transformar { it.codigo }
}

/**
 * EL inventario total de la lista es la suma de la multiplicación de la cantidad por el precio
 * de todos y cada uno de los productos de la lista. Este método permite saber si el
 * inventario de la lista es superior al millón de pesos o no.
 */
fun metodo4(prods: Lista<Producto>): Boolean {
    val inventario = prods.transformar { it.precio* it.cantidad }
    val criterio: (Int)->Int= {it}
    val sumar = inventario.sumar ( criterio )
    println (sumar)
    return sumar >1_000_000
}

/**
 * Obtener el promedio de la cantidad de aquellos productos cuyo precio
 * esté por debajo del promedio de precio de todos los productos de la lista
 */
fun metodo5(prods: Lista<Producto>): Double {
    val sumaPrecios= prods.sumar (fun (p:Producto):Int=p.precio)
    val prom = sumaPrecios/prods.tam.toDouble()
    val prodsCantprecdebajoProm = prods.filtrar { it.precio<prom }
    val sumaCantidades = prodsCantprecdebajoProm.sumar (fun(p:Producto):Int=p.cantidad).toDouble()
    return sumaCantidades/prodsCantprecdebajoProm.tam
}

//-------------------------------------------------------------------
// Operaciones con la clase Rectangulo
//-------------------------------------------------------------------

/**
 * Retorna el número de rectángulos que también son cuadrados
 */
fun metodo16(rects: Lista<Rectangulo>): Int {
    val cuad = rects.filtrar { it.altura == it.base }
    return cuad.tam
}

/**
 * Obtiene el promedio del área de los rectángulos cuya base es inferior a su altura
 */
fun metodo17(rects: Lista<Rectangulo>): Double {
    val x =rects.filtrar { it.base<it.altura }
    val suma = x.sumar (fun(r:Rectangulo):Double=r.area())
    return suma/x.tam
}

/**
 * Obtiene el rectángulo de mayor área de la lsita
 */
fun metodo18(rects: Lista<Rectangulo>): Rectangulo {
    val areamay = rects.encontrarMayor { it.base * it.altura }
    return areamay!!
}

/**
 * Obtiene la lista con las diagonales de aquellos cuadrados cuya área sea
 * superior al área que se pasa como parámetros
 */
fun metodo19(rects: Lista<Rectangulo>, areaMin: Double): Lista<Double> {
    val x =rects.filtrar { it.area()>areaMin }
    return x.transformar { sqrt(it.altura.pow(2)+it.base.pow(2)) }
}

/**
 * Halla la hipotenusa del triángulo rectángulo que tiene los catetos a y b
 */
fun hypot(a: Double, b: Double): Double = sqrt(a.pow(2)+b.pow(2))

/**
 * Un triangulo es rectangulo si un lado (el mas largo) es igual a la raiz cuadrada de
 * la suma de los cuadrados de los otros dos lados
 */
fun esRectangulo(t: Triangulo): Boolean {
    if(sqrt(t.lado1.pow(2)+t.lado2.pow(2))==t.lado3 && (t.lado3>t.lado1 && t.lado3>t.lado2)){
        return true
    }
    else if(sqrt(t.lado1.pow(2)+t.lado3.pow(2))==t.lado2 && (t.lado2>t.lado1 && t.lado2>t.lado3)){
        return true
    }
    else return sqrt(t.lado3.pow(2)+t.lado2.pow(2))==t.lado1 && (t.lado1>t.lado3 && t.lado1>t.lado2)
}

/**
 * Hallar el área del triángulo que se pasa como parámetro
 */
fun areaTriangulo(t: Triangulo): Double {
   val s = (t.lado1+t.lado2+t.lado3)/2
    return sqrt( s*((s-t.lado1)*(s-t.lado2)*(s-t.lado3)))
}

/**
 * Retorna la lista de las áreas de aquellos triángulos rectángulos de la lista
 */
fun metodo20(triangulos: Lista<Triangulo>): Lista<Double> {
    return triangulos.filtrar { esRectangulo(it) }.transformar { areaTriangulo(it) }
}

/**
 * Obtiene la lista de los identificadores de aquellos triángulos isosceles cuya área no supera a 10
 */
fun metodo21(triangulos: Lista<Triangulo>): Lista<Int> {
    return triangulos.filtrar { it.lado3==it.lado1 || it.lado3==it.lado2 || it.lado1==it.lado2}.filtrar {
        areaTriangulo(it)<10}.transformar { it.id }
}



