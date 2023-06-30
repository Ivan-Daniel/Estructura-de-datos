package taller11

import ean.collections.*

//Examen para un curso de programación que abarca los temas de listas, pilas y colas, árboles binarios (usando recursión) y comparadores.
//
//Sección 1: Listas (25 puntos)
//
//¿Qué es una lista en Kotlin? (5 puntos) : Una lista es un conjunto de elementos con un orden determinado e indexados
//Escribe un código en Kotlin para agregar un elemento al final de una lista. (5 puntos)
fun addLastElement(lista: MutableList<Int>, elem: Int): List<Int>{
    lista.add(elem)
    return lista
}
//Escribe un código en Kotlin para eliminar el primer elemento de una lista. (5 puntos)
fun removeElement(lista: MutableList<Int>): List<Int>{
    lista.remove(lista.elementAt(0)) ////////////////////////////////// MIRA ESOOOOOOOOOOOOOOOOOOOOOOOO lista.elementAt(0), es el primer elemento?
    return lista
}
//Escribe un código en Kotlin para imprimir los elementos de una lista de atrás hacia adelante. (10 puntos)
fun printListReverse(lista: List<Int>, isReverse: Boolean = false): Int{
    if (isReverse == false) {
        return when {
            lista.isEmpty() -> -1 // si esta vacia
            else -> {
                val temp = lista.first()
                println(temp)
                return printListReverse(lista.drop(1))
            }
        }
    }
    else{
        return when {
            lista.isEmpty() -> -1 // si esta vacia
            else -> {
                val temp = lista.last()
                println(temp)
                return printListReverse(lista.dropLast(1), true)
            }
        }
    }
}
//Sección 2: Pilas y colas (25 puntos)
//
//¿Qué es una pila y una cola? (5 puntos) Una pila es una lista de elementos donde solo se puede acerder al primero (punta) que es el primero que entra y primero en salir, en las colas
// solo se acede al ultimo y el primero en entrar es el ultimo en salir.
//Escribe un código en Kotlin para agregar un elemento a una pila. (5 puntos)
fun <T> agregarElementoPila(pila: IStack<T>, elem: T) : IStack<T> {
    println(pila)
    if (pila.isEmpty){
//        pila.peek()
        pila.push(elem)
        pila.pop()
    }
    println(elem)
    println(pila)
    return pila
}
//Escribe un código en Kotlin para sacar un elemento de una cola. (5 puntos)
//Escribe un código en Kotlin para imprimir los elementos de una pila en orden inverso. (10 puntos)
//Sección 3: Árboles binarios (25 puntos)
//
//¿Qué es un árbol binario y para qué se utiliza en programación? (5 puntos)
//Escribe un código en Kotlin para recorrer un árbol binario usando recursión en preorden. (10 puntos)
//Escribe un código en Kotlin para contar el número de hojas en un árbol binario. (10 puntos)
//Sección 4: Comparadores (25 puntos)
//
//¿Qué son los comparadores y cómo se utilizan en Kotlin? (5 puntos)
//Escribe un código en Kotlin para comparar dos cadenas de caracteres y determinar si son iguales. (10 puntos)
//Escribe un código en Kotlin para ordenar una lista de enteros de mayor a menor. (10 puntos)

