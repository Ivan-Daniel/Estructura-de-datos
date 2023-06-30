package taller19

import ean.colecciones.Lista
import ean.colecciones.listaVacia
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
    val depAnt = dptos.encontrarMenor { it.añoCreacion }
    return depAnt?.nombre
}

/**
 * Retorna el  departamento que tiene la superficie más grande
 * pero con una población superior a la población que se pasa
 * como parámetro.
 */
fun metodo7(dptos: Lista<Departamento>, poblacion: Int): Departamento? {
    val depFilt = dptos.filtrar { it.poblacion > poblacion }
    return depFilt.encontrarMayor { it.superficie }
}

/**
 * Retorne la lista de los nombres de los departamentos creados
 * en el siglo XX y que tenga un IDH entre 0.85 y 0.95
 */
fun metodo8(dptos: Lista<Departamento>): Lista<String> {
    val depFilt = dptos.filtrar { it.añoCreacion in 1900..1999 && it.IDH in 0.85..0.95 }
    return depFilt.transformar { it.nombre }
}

/**
 * Retorne el porcentaje de departamentos de la lista cuya densidad
 * esté por debajo del valor que se pasa como parámetro
 */
fun metodo9(deptos: Lista<Departamento>, valor: Double): Double {
    val depCumplen = deptos.contar { it.densidad < valor }
    val porc = (depCumplen.toDouble() / deptos.tam) * 100.0
    return porc
}

/**
 * Retorne el promedio de superficie de los departamentos de la lista
 * cuya poblacion sea superior a la población del departamento con menor
 * IDH de toda la lista
 */
fun metodo10(deptos: Lista<Departamento>): Double {
    val depMenorIDH = deptos.encontrarMenor { it.IDH }  //dep con menor idh
    val pobMinIDH = depMenorIDH?.poblacion ?: 0         // poblacion min desde 0
    val deptosFilt = deptos.filtrar { it.poblacion > pobMinIDH }        //filtran los deptos de la lista que tienen una población mayor a la población mínima encontrada
    val oper: (Departamento) ->  Double = { it.superficie }
    val sumSup = deptosFilt.sumar(oper)
    val cantDepFilt = deptosFilt.tam

    if (cantDepFilt == 0) {        //si la cantidad filtrada es 0 return 0.0
        return 0.0
    }

    return sumSup / cantDepFilt       //suma de superficies div en cantidd e deptos filtrados
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
    val munFilt = m.filtrar { it.departamento == depto && !it.esCapital }
    val munMayorPob = munFilt.encontrarMayor { it.poblacionUrbana }

    return munMayorPob?.nombre ?: ""
}

/**
 * Retornar el promedio de la población total (suma de la población rural y población urbana)
 * de aquellos municipios de la lista que pertenecen al departamento que se pasa
 * como parámetro y cuyo código sea múltiplo de 3 o de 5
 */
fun metodo13(municipios: Lista<Municipio>, departamento: String): Double {
    // se filtra por municipios que pertenecen al departamento que se pasa
    // como parámetro y cuyo código sea múltiplo de 3 o de 5
    val munFilt = municipios.filtrar { it.departamento == departamento && (it.codigo % 3 == 0 || it.codigo % 5 == 0) }
    //suma de la población rural y población urbana junto al filtro de municipios
    val oper: (Municipio) -> Double = {it.poblacionRural.toDouble() + it.poblacionUrbana }
    val sum =munFilt.sumar(oper)
    //se saca el promedio
    return sum/ munFilt.tam
}

/**
 * Retorne el nombre del primer municipio que inicia con J en toda la lista
 */
fun metodo14(muns: Lista<Municipio>): String {
    val munConJ = muns.encontrarElPrimeroQueCumple { it.nombre.startsWith("J") }
    return munConJ?.nombre ?: ""
}


/**
 * Retorne cuantos municipios de la lista que tienen un código
 * de 4 dígitos poseen una poblacion rural superior a la población
 * urbana
 */
fun metodo15( muns: Lista<Municipio>): Int {
    return muns.contar { it.codigo in 1000..9999 && it.poblacionRural > it.poblacionUrbana }             //NO USAR .LENGTH
}

//-------------------------------------------------------------------
// Operaciones con la clase Producto
//-------------------------------------------------------------------

/**
 * Obtener el nombre de todos los productos cuyo código es par
 */
fun metodo1(productos: Lista<Producto>): Lista<String> {        /// TRATAR DE NO USAR FOR NI WHILE
    val list1 = productos.filtrar { it.codigo % 2 == 0 }
    return list1.transformar { it.nombre }
}

/**
 * Obtener cuántos productos tienen un precio inferior al producto
 * cuyo código se pasa como parámetro
 */
fun metodo2(productos: Lista<Producto>, codProducto: Int): Int {
    val prod = productos.encontrarElPrimeroQueCumple { it.codigo == codProducto }
    return productos.contar { it.precio < prod!!.precio }
}

/**
 * Obtener una lista con los códigos de los productos cuya cantidad sea
 * superior a la cantidad mínima que se pasa como parámetro y cuyo precio
 * esté entre mil y diez mil pesos.
 *
 */
fun metodo3(productos: Lista<Producto>, cantidadMinima: Int): Lista<Int> =
     productos.filtrar { it.precio in 1000 .. 10000 && it.cantidad > cantidadMinima}
         .transformar { it.codigo }

/**
 * EL inventario total de la lista es la suma de la multiplicación de la cantidad por el precio
 * de todos y cada uno de los productos de la lista. Este método permite saber si el
 * inventario de la lista es superior al millón de pesos o no.
 */
fun metodo4(prods: Lista<Producto>): Boolean {
    val inv =prods.transformar { it.precio * it.cantidad }
    val criterio: (Int) -> Int ={it}
    val sum = inv.sumar(criterio)
    return sum > 1_000_000
}


/**
 * Obtener el promedio de la cantidad de aquellos productos cuyo precio
 * esté por debajo del promedio de precio de todos los productos de la lista
 */
fun metodo5(prods: Lista<Producto>): Double { // sacar promedió 2 veces

    val sumaPrecios= prods.sumar (fun(p:Producto):Int = p.precio) //Aqui se hace la suma de todos los presios de la lista de productos

    val prom=sumaPrecios/prods.tam.toDouble()//Aqui se halla el promedio de la lista de prods

    // pero que estos elementos sean menor que el promedio
    val prodsCantPrecDebajoProm= prods.filtrar { it.precio<prom }

    val sumaCantidades= prodsCantPrecDebajoProm.sumar (fun (p:Producto):Int= p.cantidad).toDouble()//Aqui se suman las CANTIDADES que es lo que se pide

    return sumaCantidades/prodsCantPrecDebajoProm.tam//Aqui se retorna el promedio de las cantidades
}

//-------------------------------------------------------------------
// Operaciones con la clase Rectangulo
//-------------------------------------------------------------------

/**
 * Retorna el número de rectángulos que también son cuadrados
 */
fun metodo16(rects: Lista<Rectangulo>): Int {
    return rects.contar { it.base == it.altura }
}

/**
 * Obtiene el promedio del área de los rectángulos cuya base es inferior a su altura
 */
fun metodo17(rects: Lista<Rectangulo>): Double {
    val rectFilt = rects.filtrar { it.base < it.altura }   // filtra rectángulos que base es inferior a su altura
    val oper: (Rectangulo) -> Double = {it.area() }        // se suma de acuerdo a su area
    val sum =rectFilt.sumar(oper)
    val cant = rectFilt.tam                                // cantidad de rect filtrados

    return sum / cant                                      // se hace el promedio con la suma y la cantidad
}

/**
 * Obtiene el rectángulo de mayor área de la lsita
 */
fun metodo18(rects: Lista<Rectangulo>): Rectangulo? {
    return rects.encontrarMayor { it.area() }
}

/**
 * Obtiene la lista con las diagonales de aquellos cuadrados cuya área sea
 * superior al área que se pasa como parámetros
 */
fun metodo19(rects: Lista<Rectangulo>, areaMin: Double): Lista<Double> {
    return rects.filtrar { it.base == it.altura && it.area() > areaMin }
        .transformar { sqrt(2.0) * it.base }
}

/**
 * Halla la hipotenusa del triángulo rectángulo que tiene los catetos a y b
 */
fun hypot(a: Double, b: Double): Double = sqrt(a * a + b * b)

/**
 * Un triangulo es rectangulo si un lado (el mas largo) es igual a la raiz cuadrada de
 * la suma de los cuadrados de los otros dos lados
 */
fun esRectangulo(t: Triangulo): Boolean {
    val ladoMax = maxOf(t.lado1, t.lado2, t.lado3)

    val sumCua = when (ladoMax) {
        t.lado1 -> t.lado2 * t.lado2 + t.lado3 * t.lado3
        t.lado2 -> t.lado1 * t.lado1 + t.lado3 * t.lado3
        else -> t.lado1 * t.lado1 + t.lado2 * t.lado2
    }

    return ladoMax == sqrt(sumCua)
}

/**
 * Hallar el área del triángulo que se pasa como parámetro
 */
fun areaTriangulo(t: Triangulo): Double {
    val a = t.lado1
    val b = t.lado2
    val c = t.lado3

    val s = (a + b + c) / 2.0 // Semiperimetro

    return sqrt(s * (s - a) * (s - b) * (s - c)) // Fórmula de Herón
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
    val triIso = triangulos.filtrar { it.lado1 == it.lado2 || it.lado1 == it.lado3 || it.lado2 == it.lado3}       // se filtran triangulos isoceles
        .filtrar { areaTriangulo(it) < 10}                                                                        // de los mismos se filtran que el area no supere a 10

    return triIso.transformar { it.id }                                                                           // se obtiene la lista de identificadores con esas cond.
}
