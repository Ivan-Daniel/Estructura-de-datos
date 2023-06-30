package ean.estructuradedatos.taller

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 18 de abril de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Halla el factorial del número entero n
 * n! = n * (n-1) * (n-2) * ... * 2 * 1
 */
fun factorial(n: Int): Int =
    when (n){
        1 -> 1
        else -> factorial(n-1) * n // verificar el simbolo a lado izquierdo
    }


/**
 * Halla el n-ésimo término de la serie de fibonacci
 */
fun fibonacci(n: Int): Int =
        when (n){
            1, 2 -> 1
            else -> fibonacci(n-1) + fibonacci(n-2)
         }

/**
 * Permite determinar el término n,m del triángulo de Pascal
 * n = fila, m = término
 */
fun pascal(n: Int, m: Int): Int {
    if (m == 1 || m == n + 1) {
       return 1
    }
    return pascal(n-1, m) + pascal(n-1, m-1)
}
/**
 * Halla el valor de x^y =
 * si y es cero entonces retorne 1
 * sino retorne x multiplicado por elevar x a la y - 1
 */
fun elevar(x: Int, y: Int): Int =
        if (y == 0){
            1
        }
        else{
            x * elevar(x,y-1)
        }

/**
 * Halla la suma de todos los números enteros entre 1 y n
 */
fun sumatoria(n: Int): Int =
        if (n == 1){
            1
        }
        else{
            sumatoria(n-1)+n
        }

/**
 * Halla la suma de los cuadrados de los números de 1 hasta n
 */
fun sumaCuadrados(n: Int): Int =
    if (n == 1){
        1
    }
    else{
        sumaCuadrados(n-1) + n*n
    }

/**
 * Hallar el valor de la sumatoria de 1/(2i+1) desde  1 hasta n
 */
fun serie(n: Int): Double =
    if (n == 1) {
        1.0 / 3
    }
    else{
        serie(n-1) + (1.0 / (2 * n +1))
    }

/**
 * Hallar el valor de la sumatoria de 1 hasta n de i/(i^2+1)
 */
fun sumatoria2(n: Int): Double =
    if (n == 1){
        1.0 / 2
    }
    else{
        sumatoria2(n-1) + (n / (n*n + 1.0))
    }

/**
 * Permite saber la cantidad de digitos que posee un número entero positivo n
 */
fun contarDigitos(n: Int): Int =
    when (n){
        in 0 ..9 -> 1
        else -> {
            val resto = n / 10
            val c = contarDigitos(resto)
            c+1
        }
    }

/**
 * Permite saber el número de ceros que tiene un número.
 * Por ejemplo: 2020 tiene dos ceros.
 */
fun numeroDeCeros(n: Int): Int =
    if (n < 10){
        if (n == 0){
            1
        }
        else{
            0
        }
    }
    else{
        val ult = n % 10
        val resto = n / 10
        val c = numeroDeCeros(resto)
        if (ult == 0){
            c+1
        }
        else{
            c
        }
    }

/**
 * Permite hallar la suma de los dígitos de un número entero positivo n
 */
fun sumarDigitos(n: Int): Int =
        when (n){
            in 0 ..9 -> n
            else -> {
                val resto = n / 10
                val c = sumarDigitos(resto) + n % 10
                c
            }
        }

/**
 * Un número entero positivo en múltiplo de 3 si:
 *  - tiene una cifra y es 0, 3, 6, o 9
 *  - tiene más de una cifra y la suma de sus dígitos es múltiplo de 3 (recursion)
 *  - en cualquier otro caso, el número no es múltiplo de 3
 *
 *  - NO PUEDEN USAR LA OPERACIÓN MÓDULO (%) PARA SABER SI ES DIVISIBLE
 */
fun esMultiploDe3(n: Int): Boolean =
    when {
        n < 10 -> n == 0 || n == 3 || n == 6 || n == 9
        n > 10 ->  esMultiploDe3(sumarDigitos(n))
        else -> false
    }

/**
 * Cuenta el número de dígitos pares que tiene un número entero positivo >= 1
 */
fun cantidadDigitosPares(n: Int): Int {
    if (n < 10){ // para saber si tiene un solo digito
        return if (n % 2 ==0) 1 else 0
    }else {
        var ultDigito = n % 10 // sumar el ultimo digito para saber si es par
        return if (ultDigito % 2 == 0){
            1+ cantidadDigitosPares(n / 10)
        }else{
            cantidadDigitosPares(n/10)
        }
    }

}

/**
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen los dígitos 1 y 0
 * Por ejemplo: el numero 100011110 es binario, pero 231 no lo es
 */
fun esNumeroBinario(n: Int): Boolean {
    if (n in 0..9){
        if (n == 0 || n == 1){
            return true
        }else{
            return false
        }
    }else{
        val ult = n % 10
        val resto = n / 10
        if (ult != 1 && ult != 0){
            return false
        }else{
            if (esNumeroBinario(resto)){
                return true
            }else{
                return false
            }
        }

    }
}

/**
 * Permite saber si el número dado posee el dígito indicado
 */
fun poseeDigito(n: Int, digito: Int): Boolean {
    /*
    si el numero n posee un solo digito, entonces
       si n y el digito son iguales -> retorne true sino retorne false
    sino si el número n tiene más de un dígito, entonces
       si el ultimo dígito del número n es igual al dígito, entonces
         listo, lo encontramos, retorne true
       sino
         halle el resto de n
         mire si el resto de n posee el dígito indicado
     */
    return  when {
       n < 10 -> n == digito // un solo digito
       n % 10 == digito -> true // si el ultimo digito es igual que se busca
        else -> poseeDigito( n/10, digito) // sino se busca e el resto de n el digito esperado
    }
}

/**
 * Retorna el dígito más grande que hace parte del número n
 * Ejemplo: el dígito más grande del númer 381704 es el 8
 * si el número tiene un solo dígito, el digito más grande es el numero
 * sino
 *    halle el resto y el último
 *    halla el digito mas grande del resto
 *    retorne el mayor entre el último y el dígito más grande del resto
 */
fun digitoMasGrande(n: Int): Int {
    if (n < 10){
        return n
    }else{
        val ult = n % 10
        val resto = n / 10
        val digtGrandeResto = digitoMasGrande(resto)
        var max = ult

        if ( digtGrandeResto > max){
            max = digtGrandeResto
        }
        return max
    }
}

/**
 * Halla el máximo común divisor entre m y n, utilizando el método de
 * Euclides.
 */
fun mcd(m: Int, n: Int): Int =
    if (n == 0){
        m
    }else{
        mcd(n,m % n)
    }

/**
 * Imprimir cada elemento de la lista, pero de manera recursiva
 */
fun <T> imprimirLista(lista: List<T>) {
    if (lista.isEmpty()){
        println()
    }else{
        val prim = lista.first()
        val resto = lista.subList(1,lista.size)
        println(prim)
        imprimirLista(resto)
    }
}

/**
 * Obtiene recursivamente la lista de los dígitos del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 */
fun digitos(n: Int): List<Int> {
    if (n in 0..9){
        return listOf(n)
    }else{
        val ult = n % 10
        val resto = n/10
        var lista = digitos(resto)
        lista += ult
        return lista
    }
}

/**
 * Dado un número entero positivo >= 0, retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = List(1, 1, 0, 0, 1, 1, 1, 1, 1, 1)
 */
fun convertirDecimalBinario(n: Int): List<Int> {
    if (n == 0 || n == 1){
        return listOf(n)
    }else{
        val ult = n % 2
        val resto = n / 2

        var lista = convertirDecimalBinario(resto)
        lista += ult
        return lista
    }
}

/**
 * Determina cuantas palabras en la lista son verbos.
 * Recursivamente.
 */
fun contarVerbos(palabras: List<String>): Int =
    when{
        palabras.isEmpty() -> 0
        palabras.first().endsWith("ar") || palabras.first().endsWith("er") || palabras.first().endsWith("ir") -> 1 + contarVerbos(palabras.drop(1))
        else -> contarVerbos(palabras.drop(1))
    }

/**
 * Recursion con listas: Hallar la suma de los números pares de la lista que se recibe
 * como parámetro.
 * Ejemplo: sumarParesLista([40, 21, 8, 31, 6]) == 54
 */
fun sumarParesLista(lista: List<Int>): Int {
    if (lista.isEmpty()) {
        return 0
    }
    val primerElemento = lista.first()
    val sumaRestante = sumarParesLista(lista.drop(1))
    return if (primerElemento % 2 == 0) {
        primerElemento + sumaRestante
    } else {
        sumaRestante
    }
}

/**
 * Recursión con listas: construir una función recursiva que retorne la posición del elemento en la lista
 * Si la lista está vacía, retorne -1. No se puede usar indexOf o lastIndexOf
 */
fun buscarElementoEnUnaLista(lista: List<Int>, elem: Int): Int {
     return when {
        lista.isEmpty() -> -1 // si esta vacia
        lista.first() == elem -> 0 // si el primero es igual al que se busca = 0
        else -> {
            val posicion = buscarElementoEnUnaLista(lista.drop(1), elem)
            return if (posicion == -1)  // si pos == -1 no se encontro
                -1                      // retorna -1
            else
                posicion + 1            // si es diferente de -1, se encontro pos + 1
        }
     }
}

/**
 * Traduce los diversos dígitos de la lista a un número entero
 * Ejemplo: convertirListaDigitosNumero([3, 4, 1, 7, 9]) == 34179
 */
fun convertirListaDigitosNumero(digitos: List<Int>): Int {
    return when{
        digitos.isEmpty() -> 0 // si esta vacia da 0
        else ->{
            val ultDig = digitos.last()    //saber el ultimo digito
            val restoDig = digitos.dropLast(1)  //se elimina el ultimo de la lista pero se guarda en restoDig
            return (convertirListaDigitosNumero(restoDig) * 10) + ultDig   // se le agrega la ultima posicion al resto que esta convertido
                                                                          // y se multiplica por 10 para dejarlos en la pos correspondiente
        }
    }
}

/**
 * Función genérica y recursiva que permite saber si un elemento está dentro
 * de la lista. No debe usarse la función indexOf o contains. Debe ser
 * recursiva. Para buscar un elemento hay que tener en cuenta
 * - si la lista está vacía, el elemento no está
 * - si el primero de la lista es igual al elemento, retornamos true (el elemento está)
 * - sino es igual al primero, entonces hay que ver si el elemento está en el resto de la lista
 */
fun <T> existeElemento(lista: List<T>, elem: T): Boolean {
    if (lista.isEmpty()){
        return false
    }
    if (lista.first() == elem){
        return true
    }
    return existeElemento(lista.drop(1),elem)
}

/** Escribir una función recursiva que, sin usar pilas ni colas
 * ni ninguna otra lista, obtenga la misma lista, pero invertida
 */
fun invertirLista(lista: List<Char>): List<Char> {
    return when{
        lista.size == 1 -> lista
        else -> {
            val prim = lista.first()    //saber el primer digito
            val resto = lista.drop(1)  //se elimina el resto de la lista pero se guarda en resto
            return invertirLista(resto) + prim //se invierte el resto y se agrega el primero al final
        }
    }
}

/**
 * Una palabra es palíndrome si se lee igual de izquierda a derecha y de derecha
 * a izquierda. Esta función recibe la palabra (sin espacios) y de forma recursiva
 * determina si la palabra es palíndrome.
 */
fun esPalindrome(palabra: String): Boolean =
    if (palabra.length <= 1) {     // si es una letra es V
        true
    } else {                         // si tiene mas de 1 letra
        val prim = palabra.first()   // primera letra
        val ult = palabra.last()     // ultima letra

        if (prim != ult){
            false
        } else {
            var centro = palabra.substring(1, palabra.length - 1) // mira las letras del centro sin contar la primera ni la ult
            esPalindrome(centro)
        }
    }

/**
 * Recursividad con listas. Escriba una función recursiva
 * Obtiene el número más grande de la lista. Si la lista está vacía retorne el número
 * entero más pequeño.
 */
fun mayorDeUnaLista(lista: List<Int>): Int {
    return  if (lista.isEmpty()){
        Int.MIN_VALUE                       // si la lista esta vacia retorna el entero mas pequeño
    }else{
        val prim = lista.first()
        val resto = lista.drop(1)
        val max = mayorDeUnaLista(resto)    // sacamos el mayor del resto de la lista sin saber el primero

        if (prim > max){                    // si el primero es mayor al mayor del resto, retorna prim sino max
            prim
        }else{
            max
        }
    }
}

/**
 * Una clase auxiliar
 */
data class Punto(val x: Int, val y: Int) {
    fun distanciaAlOrigen(): Double = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
}

/**
 * Recursivamente, obtener una lista con aquellos puntos que están en el origen o
 * que hacen parte del primer cuadrante.
 */
fun puntosPrimerCuadrante(puntos: List<Punto>): List<Punto> {
    return when {
        puntos.isEmpty() -> emptyList()    //si la lista esta vacia, retorna vacia
        else -> {
            val prim = puntos.first()
            val resto = puntos.drop(1)
            val puntosPrimerCuadrante = puntosPrimerCuadrante(resto)    // se busca los puntos del primer cuadrante del resto
            if (prim.x >= 0 && prim.y >= 0 || prim.x == 0 && prim.y == 0) {     //si primer elemento de x es >= 0 y primer elemento de y es >= 0 ò
                                                                                // primer elemento de x es == 0 y primer elemento de y es == 0
                listOf(prim) + puntosPrimerCuadrante                            // retorna la lista creada de prim + puntos del primer cuadrante del resto
            } else {
                puntosPrimerCuadrante                                           // sino retorna los puntos del primer cuadrante del resto
            }
        }
    }
}

/**
 * Recursivamente, obtiene el punto que está más lejano del origen.
 * Si la lista esta vacía, retorne null
 * Si la lista tiene un solo elemento, retorne ese elemento
 * si la lista tiene más de un elemento, tome el primer elemento y
 * compárelo con el punto más lejano del resto de la lista.
 */
fun puntoMasLejano(puntos: List<Punto>): Punto? {
    return when {
        puntos.isEmpty() -> null                 // si la lista esta vacia retorna null
        puntos.size == 1 -> puntos.first()       // si tiene un elemento lo retorna
        else -> {
            val prim = puntos.first()
            val resto = puntos.drop(1)
            val puntoMasLejano = puntoMasLejano(resto)          //punto mas lejano del resto
            if (puntoMasLejano == null) {                       //si punto mas lejano del resto es igual a null
                prim
            } else {
                val distOrigen = Math.sqrt(prim.x.toDouble().pow(2) + prim.y.toDouble().pow(2))         //utilizando el teorema de ptagoras calcula el prim
                val disOrigenLejano = Math.sqrt(puntoMasLejano.x.toDouble().pow(2) + puntoMasLejano.y.toDouble().pow(2))     //utilizando el teorema de ptagoras calcula el punto mas lejano
                if (distOrigen > disOrigenLejano) {         // si la distancia del origen (prim) es mayor al de punto lejano
                    prim                                    //retorna el prim
                } else {
                    puntoMasLejano                          //sino retorna el punto mas lejando
                }
            }
        }
    }
}


