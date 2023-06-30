package tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Facultad de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Marzo 15, 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IStack
import ean.collections.TLinkedStack

/**
 * Objeto que permite convertir una expresión infija normal a una expresión en notación
 * postfija. Utiliza pilas para realizar la conversión.
 */
object Evaluador {

    //-------------------------------------
    // Métodos
    //-------------------------------------

    /**
     * Verifica que la expresión tiene los símbolos de agrupación bien balanceados
     * @return true si la expresión está balanceados
     */
    fun estánSímbolosAgrupaciónBalanceados(expresion: List<String>): Boolean {
        var pilaSimbolos: IStack<String> = TLinkedStack()

        for (elem in expresion) {
            if (elem == "(" || elem == "[" || elem == "{")  {
                pilaSimbolos.push(elem)
            } else if(elem == ")" || elem == "]" || elem == "}"){
                if (pilaSimbolos.isEmpty) {
                    return false
                }
                var delimitador = pilaSimbolos.peek()
                pilaSimbolos.pop()
                if ((elem == ")" && delimitador != "(") ||
                    (elem == "]" && delimitador != "[") ||
                    (elem == "}" && delimitador != "{")) {
                    return false
                }
            }
        }

        if (!pilaSimbolos.isEmpty) {
            return false
        }else {
            return true
        }
    }

    /**
     * Transforma la expresión, cambiando los simbolos de agrupación [] y {} por ()
     */
    fun reemplazarDelimitadoresPorParéntesis(expresion: MutableList<String>): Unit {
        for (i in 0 until expresion.size) {
            when (expresion[i]) {
                "[" -> expresion[i] = "("
                "]" -> expresion[i] = ")"
                "{" -> expresion[i] = "("
                "}" -> expresion[i] = ")"
            }
        }
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     */
    fun convertirAPostfijo(expresion: List<String>): List<String> {
        val pila: IStack<String> = TLinkedStack()
        val lista = mutableListOf<String>() //lista de salida

        for (term in expresion) {
            when (term) {
                    "+" -> pila.push(term)

                    "-" -> pila.push(term)

                    "*" -> pila.push(term)

                    "/" -> pila.push(term)

                    "%" -> pila.push(term)

                    "(" -> {}

                    ")" -> {
                        var salida = pila.peek()
                        pila.pop()
                        lista.add(salida)
                    }
                else -> {
                    lista.add(term)
                }
            }
        }

        while (!pila.isEmpty){
            var x = pila.peek()
            lista.add(x)
            pila.pop()
        }
        return lista;
    }

    /**
     * Realiza la evaluación de la expresión postfija almacenada en la lista
     * llamada "expresión". Realiza las operaciones de acuerdo al algoritmo
     * presentado.
     */
    fun evaluarExpresiónPostfija(expresion: List<String>): Int {  //cambia string a num
        val pila: IStack<Int> = TLinkedStack()
        for (term in expresion) {
            if (term.toIntOrNull() != null){
                pila.push(term.toInt())
            }else{
                var operando1 = pila.peek()
                pila.pop()
                var operando2 = pila.peek()
                pila.pop()
                var resultado = when (term){
                    "+" -> operando1 + operando2
                    "-" -> operando2-operando1
                    "*" -> operando1 * operando2
                    "/" -> operando2 / operando1
                    else -> operando2 % operando1
                }
                pila.push(resultado)
            }
        }
        return pila.peek()
    }
}
