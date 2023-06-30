/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas
 * Basado en el Proyecto Cupi2 de Uniandes
 *
 * Taller de Ordenamiento
 * Fecha: 18 de mayo de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package taller17

import ean.colecciones.Lista
import ean.colecciones.listaVacia

/**
 * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
 * Complejidad: O(n^2)
 */
fun bubbleSort(a: Lista<Int>): Unit {
    val n = a.tam
    repeat(n){ //remplazo de for se repite n veces
        for (j in 0 until n-1){
            if (a[j]> a[j+1]){
                val aux = a[j+1]
                a[j+1] = a[j]
                a[j] = aux
            }
        }
    }
}

/**
 * Desarrolle la busqueda binaria del elemento en la lista a
 */
fun busquedaBinaria(a: Lista<Int>, elem: Int): Int {
    var ini = 0
    var fin = a.tam - 1

    while (ini <= fin){
        val mitad = (ini + fin)/2
        when{
            a[mitad] == elem -> return mitad
            a[mitad] > elem -> fin = mitad -1
            a[mitad] < elem -> ini = mitad +1
        }
    }
    return -1
}

/**
 * Información de un aspirante a un empleo en una bolsa de empleo
 */
data class Aspirante(val nombre: String,
                     val profesion: String,
                     val añosExperiencia: Int,
                     val edad: Int,
                     val telefono: String) : Comparable<Aspirante> {
    override fun compareTo(other: Aspirante): Int = this.nombre.compareTo(other.nombre)
}

/**
 * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra.
 * Si no se encuentra ningún aspirante con ese nombre se retorna -1.
 * Utilice la búsqueda lineal típica
 */
fun buscarAspirante(lista: Lista<Aspirante>, nombre: String): Int {
    for (i in 0 until lista.tam) {
        if (lista[i].nombre == nombre) {
            return i // Se encontró el aspirante, se retorna la posición
        }
    }
    return -1 // No se encontró el aspirante
}

/**
 * Busca un aspirante según su
 * nombre, utilizando una búsqueda binaria.
 * Si no se encuentra ningún aspirante con ese nombre se retorna -1.
 * OJO: la lista de aspirantes ya está ordenada, puede confiar en eso
 */
fun buscarBinarioPorNombre(lista: Lista<Aspirante>, nombre: String): Int {
    var ini = 0
    var fin = lista.tam - 1

    while (ini <= fin) {
        val mitad = (ini + fin) / 2
        val asp = lista[mitad]
        if (lista[mitad].nombre == nombre) {
            return mitad  // encontramos el elemento
        }
        if (lista[mitad].nombre > nombre) {
            fin = mitad - 1
        } else {
            ini = mitad + 1
        }
    }
    return -1
}

/**
 * Ordena la lista de aspirantes por nombre usando el algoritmo de burbuja
 */
fun ordenarPorNombre(aspirantes: Lista<Aspirante>) {
    val n = aspirantes.tam
    repeat(n){ //remplazo de for se repite n veces
        for (j in 0 until n-1){
            if (aspirantes[j]> aspirantes[j+1]){
                val aux = aspirantes[j+1]
                aspirantes[j+1] = aspirantes[j]
                aspirantes[j] = aux
            }
        }
    }
}

/**
 * Ordena la lista de aspirantes por edad usando el algoritmo de selección
 */
fun ordenarPorEdad(aspirantes: Lista<Aspirante>) {
    for (i in 0 until aspirantes.tam) {
        var menor = aspirantes[i].edad
        var posMenor = i
        // Vamos a buscar la posición del menor  de i en adelante
        for (j in i + 1 until aspirantes.tam ) {
            if (aspirantes[j].edad < menor) {
                menor = aspirantes[j].edad
                posMenor = j
            }
        }
        // Después de haber encontrado la posición del menor, lo
        // intercambiamos con el que se encuentra en la posición i
        val aux = aspirantes[i]
        aspirantes[i]= aspirantes[posMenor]
        aspirantes[posMenor] = aux
    }
}

/**
 * Ordena la lista de aspirantes por años de experiencia utilizando el algoritmo de inserción
 */
fun ordenarPorAñosDeExperiencia(aspirantes: Lista<Aspirante>) {

    // Iniciamos desde la posición 1 a ordenar
    for (i in 1 until aspirantes.tam) {
        for (j in 0 until aspirantes.tam - 1) {
            // elem es el elemento que vamos a pasar
            // de la zona desordenada a la ordenada
            val elem = aspirantes[i]
            var j = i - 1
            // Vamos a desplazar todos los elementos
            // a la derecha, buscando el lugar donde va
            // a ir el elemento que tenemos
            while (j >= 0 && elem.añosExperiencia < aspirantes[j].añosExperiencia) {
                aspirantes[j + 1] = aspirantes[j]
                j--
            }
            // Guardamos el elemento en el lugar que le
            // corresponde dentro del sector ordenado
            aspirantes[j + 1] = elem
        }
    }
}

/**
 * Ordena la lista de aspirantes por profesión usando el algoritmo de ordenamiento shell sort
 */
fun ordenarPorProfesion(aspirantes: Lista<Aspirante>) {
//    val n = aspirantes.tam
//    var brecha = n / 2
//
//    while (brecha > 0) {
//        for (i in brecha until n) {
//            val temp = aspirantes[i]
//            var j = i
//
//            while (j >= brecha && aspirantes[j - brecha].profesion > temp.profesion) {
//                aspirantes[j] = aspirantes[j - brecha]
//                j -= brecha
//            }
//            aspirantes[j] = temp
//        }
//        brecha /= 2
//    }

    val n = aspirantes.tam
    var salto = n
    var ordenado : Boolean

    while (salto > 1){
        salto /= 2
        do {
            ordenado = true
            for (j in 0 until n - salto){
                val k = j + salto
                if (aspirantes[j].profesion> aspirantes[k].profesion){
                    val temp = aspirantes[j]
                    aspirantes[j] = aspirantes[k]
                    aspirantes[k] = temp
                    ordenado=false
                }
            }
        }while (!ordenado)
    }
}

/**
 * Ordena la lista de aspirantes por nombre utilizando el algoritmo de ordenamiento merge sort
 */
fun ordenarPorNombreConMergeSort(a: Lista<Aspirante>) {
    /**
     * Obtiene los elementos de la lista ubicados en la mitad inferior de la misma
     * es decir, en las posiciones desde la cero hasta la mitad de la lista
     */
    fun obtenerMitadInferior(lista: Lista<Aspirante>): Lista<Aspirante> {
        val mitad = lista.tam / 2                   // mitad de la lista
        val mitadInf = listaVacia<Aspirante>()     // lista donde guarda la mitad inf

        for (i in 0 until mitad) {           // si esta en la pos de 0 a mitd
            mitadInf.agregarAlFinal(lista[i])     // se agregar a la lista
        }

        return mitadInf                          // retorna la lista
    }

    /**
     * Obtiene los elementos de la lista ubicados en la mitad superior de la misma
     * es decir, en las posiciones desde la mitad + 1 hasta el final de la lista
     */
    fun obtenerMitadSuperior(lista: Lista<Aspirante>): Lista<Aspirante> {
        val mitad = lista.tam / 2                   // mitad de la lista
        val mitadSup = listaVacia<Aspirante>()     // lista donde guarda la mitad sup

        for (i in mitad+1 until lista.tam) { // si esta en la mitad +1  al final
            mitadSup.agregarAlFinal(lista[i])     // se agregar a la lista
        }

        return mitadSup                           // retorna la lista
    }

    /**
     * Retorna la mezcla ordenada de las listas a y b, usando el nombre como criterio
     */
    fun mezclarListas(a: Lista<Aspirante>, b: Lista<Aspirante>): Lista<Aspirante> {
        var i = 0
        var j = 0                                   // índices para recorrer listas
        val mezcla = listaVacia<Aspirante>()        //lista vacia

        while (i < a.tam && j < b.tam) {           //Mientras ambos índices son menores que los tamaños de las listas
            if (a[i].nombre <= b[j].nombre) {      //compara los nombres de los aspirantes en las pos
                mezcla.agregarAlFinal(a[i])        //agrega a la lista mezclada
                i++
            } else {
                mezcla.agregarAlFinal(b[j])
                j++
            }
        }

        while (i < a.tam) {                       //quedan elementos en la lista a
            mezcla.agregarAlFinal(a[i])           //se agrega a la lista vacia
            i++
        }

        while (j < b.tam) {                       //quedan elementos en la lista a
            mezcla.agregarAlFinal(b[j])          //se agrega a la lista vacia
            j++
        }

        return mezcla
    }

    //------------------------------------------------------------------------------
    // Función Principal del MergeSort
    //------------------------------------------------------------------------------
    if (a.tam >= 2) {
        if (a.tam == 2) {
            if (a[0].nombre > a[1].nombre) {
                a[0] = a[1]
                a[1] = a[0]
            }
        }
        else {
            // Algoritmo MergeSort.

            // 1. Particione la lista en dos mitades
            val p: Lista<Aspirante> = obtenerMitadInferior(a)
            val q: Lista<Aspirante> = obtenerMitadSuperior(a)

            // 2. ordene cada mitad usando mergesort
            ordenarPorNombreConMergeSort(p)
            ordenarPorNombreConMergeSort(q)

            // 3. Mezcle las dos listas ordenadas y copielas a la lista de resultado
            val resultado = mezclarListas(p, q)
            a.limpiar()
            a.agregarLista(resultado)
        }
    }
}

/**
 * Ordene la lista de aspirantes por nombre utilizando el algoritmo de ordenamiento quick sort
 */
fun ordenarPorNombreConQuickSort(lista: Lista<Aspirante>) {
    /**
     * Obtener los aspirantes que tengan un nombre inferior al pivote en la lista a
     */
    fun menoresAlPivote(a: Lista<Aspirante>, pivote: Aspirante): Lista<Aspirante> {
        val nomInf = listaVacia<Aspirante>()

        for (i in 0 until lista.tam) {
            val asp = a[i]
            if (asp.nombre < pivote.nombre) {
                nomInf.agregarAlFinal(asp)
            }
        }
        return nomInf
    }

    /**
     * Obtener los aspirantes que tengan un nombre superior al pivote en la lista a
     */
    fun mayoresAlPivote(a: Lista<Aspirante>, pivote: Aspirante): Lista<Aspirante> {
        val nomSup = listaVacia<Aspirante>()

        for (i in 0 until lista.tam) {
            val asp = a[i]
            if (asp.nombre > pivote.nombre) {
                nomSup.agregarAlFinal(asp)
            }
        }

        return nomSup
    }

    //-----------------------------------------------------------------
    // Función Principal
    //-----------------------------------------------------------------
    if (lista.tam >= 2) {
        if (lista.tam == 2) {
            if (lista[0] > lista[1]) {
                lista[0] = lista[1]
                lista[1] = lista[0]
            }
        }
        else {
            // Algoritmo QuickSort

            // 1. Obtener el pivote, en este caso puede ser el nombre del primer elemento
            val pivote = lista[0]

            // 2. Obtener los menores y los mayores al pivote
            val mayores = mayoresAlPivote(lista, pivote)
            val menores = menoresAlPivote(lista, pivote)

            // 3. Ordene estas dos últimas listas usando el quicksort
            ordenarPorNombreConQuickSort(mayores)
            ordenarPorNombreConQuickSort(menores)

            // 4. Ahora pegamos los pedazos junto con el pivote
            lista.limpiar()
            lista.agregarLista(menores)
            lista.agregarAlFinal(pivote)
            lista.agregarLista(mayores)
        }
    }
}

/**
 * Se retornó la posición donde se encuentra el aspirante más joven.
 * Si no hay aspirantes en la lista se retornó -1
 */
fun buscarAspiranteMasJoven(aspirantes: Lista<Aspirante>): Int {
    if (aspirantes.estaVacia()) {
        return -1
    }

    var posMasJov = 0
    var edadMasJov = aspirantes[0].edad

    for (i in 1 until aspirantes.tam) {
        val edadActual = aspirantes[i].edad
        if (edadActual < edadMasJov) {
            posMasJov = i
            edadMasJov = edadActual
        }
    }
    return posMasJov
}

/**
 * Se retornó la posición donde se encuentra el aspirante con mayor experiencia.
 * Si no hay aspirantes en la bolsa se retornó -1
 */
fun buscarAspiranteMayorExperiencia(aspirantes: Lista<Aspirante>): Int {
    if (aspirantes.estaVacia()) {
        return -1
    }
    var posMasExp = 0
    var edadMasJoven = aspirantes[0].añosExperiencia

    for (i in 1 until aspirantes.tam) {
        val edadActual = aspirantes[i].añosExperiencia
        if (edadActual > edadMasJoven) {
            posMasExp = i
            edadMasJoven = edadActual
        }
    }
    return posMasExp
}
