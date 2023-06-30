package taller11

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ean.collections.*

class RepasoKtTest{
    @Test
    fun pruebaEjercicio01() {
        val lista: MutableList<Int> = mutableListOf(2,5,6,7)
        assertEquals(mutableListOf(2,5,6,7,5), addLastElement(lista, 5))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio02() {
        val lista: MutableList<Int> = mutableListOf(2,5,6,7)
        assertEquals(mutableListOf(5,6,7), removeElement(lista))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio03() {
        val lista: List<Int> = listOf(2,5,6,7)
        assertEquals(-1,printListReverse(lista))
        assertEquals(-1,printListReverse(lista, true))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio04() {
        val p: IStack<Int> = TLinkedStack()
        val p2: IStack<Int> = TLinkedStack()

        p2.push(100)
        agregarElementoPila(p,100)

        assertEquals(/* expected = */ p2, /* actual = */ p)
        println("Prueba Superada ✔")
    }
}