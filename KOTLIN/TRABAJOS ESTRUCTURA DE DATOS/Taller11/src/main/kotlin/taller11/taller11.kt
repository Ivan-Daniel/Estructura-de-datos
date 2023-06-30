package taller11

/**
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad EAN (Bogotá - Colombia)
* Departamento de Sistemas
* Faculta de Ingeniería
*
* Proyecto Taller de Pilas
* Autor: Universidad EAN - Marzo 23, 2022
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import ean.collections.*


/**
 * A partir de una pila de palabras, retornar cuántas de esas
 * palabras son verbos. La pila original no debe verse modificada
 */
fun contarVerbos(palabras: IStack<String>): Int {
    var copia = palabras.copy()
    var contador = 0

    while (!copia.isEmpty){
        val pal = copia.peek().toLowerCase()//cambia a minusculas
        if (pal.endsWith("ar") || pal.endsWith("er") || pal.endsWith("ir")){
            contador++
        }
        copia.pop()
    }
    return contador
}

/**
 * Ejercicio 02
 * Función para sumar los números pares de tres cifras que hay en una
 * pila de enteros. La pila original no debe verse modificada.
 */
fun sumarParesTresCifras(pila: IStack<Int>): Int {
    var copia = pila.copy()
    var sum = 0

    while (!copia.isEmpty){
        var x = copia.peek()
        if (x in 100..999 && x % 2 == 0) {
            sum += x
        }
        copia.pop()
    }
    return sum
}

/**
 * Ejercicio 03
 * Función para determinar cuál es el número más grande de dos cifras que hay
 * en una pila de números. Si no existe ningún número de dos cifras, retorne
 * null. La pila original no debe verse modificada.
 */
fun mayorDeDosCifras(pila: IStack<Int>): Int? {
    var max: Int? = null
    var copia = pila.copy()

    while (!copia.isEmpty){
        var x = copia.peek()
        if (x >= 10 && x <= 99 && (max == null || x > max)) {
            max = x
        }
        copia.pop()
    }
    return max
}

/**
 * Ejercicio 01
 * Obtener y retornar el fondo de la pila. La pila original no debe verse
 * modificada.
 */
fun <T> obtenerFondo(pila: IStack<T>): T {
    //copia de pila original
    val copia =pila.copy()
    //pila vacia
    val temp = TLinkedStack<T>()
    //recorre copia
    while (!copia.isEmpty){
        //elemento tope
        val elem = copia.peek()
        //agrega a pila temp
        temp.push(elem)
        //elimina elem copia
        copia.pop()
    }
    // tope de la temporal, que es el fondo
    return temp.peek()
}

/**
 * Ejercicio 04
 * Hacer una función externa que permita guardar un elemento en el fondo
 * de la pila. GEnérica. La pila original si debe verse modificada.
 */
fun <T> guardarEnElFondo(p: IStack<T>, elem: T) {
    val temp = TLinkedStack<T>()
    while (!p.isEmpty){
        temp.push(elem)
        p.pop()
    }
    p.push(elem)
}

/**
 * Ejercicio 05
 * Función genérica para obtener el tamaño de una pila. La pila
 * original no debe verse modificada.
 */
fun <T> tamPila(p: IStack<T>) : Int {
    var copia = p.copy()
    var contador = 0

    while (!copia.isEmpty){
        val elem = copia.peek()
        p.push(elem)
        copia.pop()
        contador++
    }
    return contador
}

/**
 * Ejercicio 06
 * Función genérica que permite Invertir una pila en otra.
 * Recibe la pila y retorna la pila, pero invertida.
 * Solo puede usarse las operaciones de las pilas, no listas.
 */
fun <T> invertirPila(pila: IStack<T>): IStack<T> {
    var invertida = TLinkedStack<T>()

    while (!pila.isEmpty){
        invertida.push(pila.peek())
        pila.pop()
    }
    return invertida

}


/**
 * Ejercicio 07
 * Función genérica que copia una pila en otra.
 * La función recibe la pila y retorna la copia.
 * No debe usarse el método copy de la pila ni listas.
 * La pila original no debe verse modificada.
 */
fun <T> copiarPila(pila: IStack<T>): IStack<T> {
    val copia = TLinkedStack<T>()
    val temp = TLinkedStack<T>()
    while (!pila.isEmpty){
        temp.push(pila.peek())
        pila.pop()
    }
    while (!temp.isEmpty) {
        copia.push(temp.peek())
        pila.push(temp.peek())
        temp.pop()
    }
    return copia

}


/**
 * Ejercicio 08
 * Función genérica que recibe una pila y un elemento y que elimina de la
 * pila todas las ocurrencias del elemento que se recibe como parámetro.
 * No debe retornar nada.
 */
fun <T> eliminarElementoPila(pila: IStack<T>, elem: T) {
    var temp = TLinkedStack<T>()

    while (!pila.isEmpty){
        var x = pila.peek()
        if (x != elem){
            temp.push(x)
        }
        pila.pop()
    }
    while (!temp.isEmpty){
        var x = temp.peek()
        pila.push(x)
        temp.pop()
    }
}

/**
 * Ejercicio 09
 * Invertir una lista de números utilizando una pila. La función no retorna,
 * debe modificar la lista
 */
fun invertirLista(list: MutableList<Int>) { // usa add y no push
    val pila =TLinkedStack<Int>()

    for (i in list) {
        pila.push(i)
    }
    list.clear()
    while (!pila.isEmpty){
        list.add(pila.peek())
        pila.pop()
    }
}


/**
 * Ejercicio 10
 * Usar una pila de letras para Determinar si una frase es palindrome o no
 * Retorne true si la frase es palíndrome y false si no lo es.
 */
fun palindrome(frase: String): Boolean { // se crea una invertida y se revisa si son iguales o no
    val pila: IStack<Char> = TArrayStack()

    for (letra in frase){
        pila.push(letra)
    }

    var invertida = ""
    while (!pila.isEmpty){
        invertida += pila.peek()
        pila.pop()
    }
    if (invertida.equals(frase)){
        return true
    }
    else return false
}

/**
 * Ejercicio 11
 * Determinar si dos pilas son iguales.
 * Retorne true si son idénticas o false si no es así
 * Las pilas no deben ser modificadas.
 */
fun <T> igualesPilas(pila1: IStack<T>, pila2: IStack<T>): Boolean {
    var copiap1 = copiarPila(pila1)
    var copiap2 = copiarPila(pila2)

    while (!copiap1.isEmpty && !copiap2.isEmpty){
        if (copiap1.peek() != copiap2.peek()){
            return false
        }
        copiap1.pop()
        copiap2.pop()
    }
    if (tamPila(copiap1) != tamPila(copiap2)){
        return false
    }
    return true
}

/**
 * Escriba una función que reemplace cada aparición del elemento
 * oldItem por el elemento newItem en la pila.
 */
fun reemplazarElementoPila(pila: IStack<Int>, oldItem: Int, newItem: Int) {
    var temp = TLinkedStack<Int>()

    while (!pila.isEmpty){
        var x = pila.peek()
        if (x == oldItem){
            pila.pop()
            temp.push(newItem)
        }else{
            temp.push(x)
            pila.pop()
        }
    }
    while (!temp.isEmpty){
        var x = temp.peek()
        pila.push(x)
        temp.pop()
    }
}

// Una clase que representa perros
data class Perro(val nombre: String, val raza: String, val edad: Int)

/**
 * Escriba una función que reciba una pila de perros y que retorne
 * una lista con los nombres de aquellos perros que tengan un nombre
 * que termine en vocal y cuya edad sea inferior a la edad que se
 * pasa como parámetro. La pila original no debe verse modificada.
 */
fun perrosMenoresEdad(perros: IStack<Perro>, edad: Int): List<String> {
    var copia = perros.copy()
    var perrosFiltrados = mutableListOf<String>()
    while (!copia.isEmpty){
        var nombre=copia.peek().nombre
        var edadp=copia.peek().edad
        if((nombre.endsWith("a")
                    || nombre.endsWith("e")
                    || nombre.endsWith("i")
                    || nombre.endsWith("o")
                    || nombre.endsWith("u"))
            && (edadp < edad)){
            perrosFiltrados.add(nombre)
        }
        copia.pop()
    }
    return perrosFiltrados
}

/**
 * Escriba esta función que reciba una pila de perros y que retorne
 * el perro más joven que pertenece a la raza que se pasa como
 * parámetro. La pila original no debe verse modificada, no puede
 * usarse listas ni funciones de orden superior. Si no hay perros
 * de esa raza, deberá retornarse null.
 */
fun perroMasJoven(perros: IStack<Perro>, raza: String): Perro? {
    var perroJoven: Perro? = null
    var menoredad = Int.MAX_VALUE

    val temp = TLinkedStack<Perro>()
    while (!perros.isEmpty) {
        val x = perros.peek()
        if (x.raza == raza && x.edad < menoredad) {
            perroJoven = x
            menoredad = x.edad
        }
        temp.push(x)
        perros.pop()
    }
    while (!temp.isEmpty) {
        perros.push(temp.peek())
        temp.pop()
    }
    return perroJoven
}

fun findYoungestDogByBreed(dogs: IStack<Perro>, breed: String): Perro? {
    var youngest: Perro? = null

    // Iterar sobre la pila de perros
    while (!dogs.isEmpty) {
        val currentDog = dogs.peek()

        // Si el perro actual es de la raza buscada y es más joven que el perro más joven encontrado hasta ahora, actualizar el perro más joven
        if (currentDog.raza == breed && (youngest == null || currentDog.edad < youngest.edad)) {
            youngest = currentDog
        }
        dogs.pop()
    }

    // Devolver el perro más joven encontrado o null si no se encontró ninguno de la raza buscada
    return youngest
}