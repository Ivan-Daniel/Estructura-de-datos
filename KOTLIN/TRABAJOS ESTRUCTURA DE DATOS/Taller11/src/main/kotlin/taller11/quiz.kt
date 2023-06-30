package taller11

import ean.collections.IStack

class Persona (var nombre: String, var edad: Int, var libros: Int){}
class Caja (var capacidad : Int){}

fun cajasDeLibros(pila: IStack<Persona>, caja: Caja): Int{
    var copia = pila.copy()
    var numCajas = 0
    var numP = 0

    while (!copia.isEmpty) {
        val x = copia.peek()
        if (x.edad > 18 ) {
            numP += x.libros
        }
        copia.pop()
    }

    numCajas = numP / caja.capacidad
    if (numP % caja.capacidad != 0){
        numCajas++
    }

    return numCajas
}
