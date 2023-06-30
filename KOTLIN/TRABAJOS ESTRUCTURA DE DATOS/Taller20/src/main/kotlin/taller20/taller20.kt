package taller20

import ean.colecciones.Lista
import kotlin.math.pow

/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto Programación Funcional
 * @author Luis Cobo (lacobo@universidadean.edu.co)
 * Fecha: Mayo 31, 2023
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

// Esta clase guarda la información de una persona
data class Persona(val cedula: Int,
                   val edad: Int,
                   val genero: Char,  // 'H' para hombre y 'M' para mujer
                   val numeroDeHijos: Int,
                   val nivelEducativo: String, // PREESCOLAR, PRIMARIA, SECUNDARIA, UNIVERSITARIA
                   val estratoSocioeconomico: Int,
                   val ingresos: Int,
                   val peso: Int,    // en kilos
                   val altura: Int,  // en centímetros
                   val fuma: Boolean,
                   val usaLentes: Boolean,
                   val tieneCasaPropia: Boolean,
                   val tieneAutomovil: Boolean) {

    // Método interno para hallar el Indice de Masa Corporal = peso / (altura en metros)ˆ2
    fun IMC(): Double = this.peso / (this.altura/100.0).pow(2)

    // A partir del IMC permite obtener la categoría del estado del peso, así:
    //    IMC                 Nivel de peso
    //    Por debajo de 18.5  Bajo peso
    //    [18.5, 25.0)        Normal
    //    [25.0 – 30)         Sobrepeso
    //    30.0 o más          Obesidad
    fun nivelDePeso(): String {
      return when {
            IMC()<18.5->"Bajo peso"
            IMC()>=18.5 && IMC()<25.0->"normal"
            IMC()>=25.0 && IMC()<30.0->"sobrepeso"
            else-> "obesidad"
        }
    }
}

/**
 * Ejercicio 1: Cuantos hombres hay en la lista que se recibe como parámetro
 */
fun ejercicio1(personas: Lista<Persona>): Int {
    return personas.contar { it.genero == 'H' }
}

/**
 * Cuál es la cédula de los hombres obesos que nacieron hace más de 55 años
 */
fun ejercicio2(personas: Lista<Persona>): Lista<Int> {
    return personas.filtrar {it.genero == 'H' && it.nivelDePeso() == "obesidad" && it.edad > 55}
            .transformar {it.cedula }
}

/**
 * De los estratos 2, 3 o 4, cuál tiene la mayor cantidad de mujeres fumadoras sin hijos
 */
fun ejercicio3(personas: Lista<Persona>): Int {
    val cantMujeres = personas.filtrar {it.genero == 'M' && it.fuma && it.numeroDeHijos == 0 }
    var cant2 = cantMujeres.contar {it.estratoSocioeconomico == 2}
    var cant3 = cantMujeres.contar {it.estratoSocioeconomico == 3}
    var cant4 = cantMujeres.contar {it.estratoSocioeconomico == 4}

    return when{
        cant2>=cant3 && cant2>=cant4->2
        cant3>=cant2 && cant3>=cant4->3
        else -> 4
    }
}

/**
 * Hallar la suma de los ingresos de las personas que tienen casa, usan lentes, no tienen automóvil y tienen el nivel
 * educativo que se pasa como parámetro
 */
fun ejercicio4(personas: Lista<Persona>, nivel: String): Int {
    var p =personas.filtrar { it.tieneCasaPropia && it.usaLentes && !it.tieneAutomovil && it.nivelEducativo==nivel }
    return p.sumar (
            fun (p:Persona):Int = p.ingresos
    )
}

/**
 * Determine si hay alguna mujer que tiene casa y automovil, pero con un ingreso inferior al que se pasa como parámetro
 */
fun ejercicio5(personas: Lista<Persona>, ingreso: Int): Boolean {
    return personas.contar { it.genero == 'M' && it.tieneCasaPropia && it.tieneAutomovil && it.ingresos < ingreso} > 0
}

/**
 * Determine si todas las personas de la lista son hombres con sobrepeso y que nacieron en la última década del siglo XX
 */
fun ejercicio6(personas: Lista<Persona>): Boolean {
    return personas.contar { it.genero == 'H' && it.nivelDePeso() == "sobrepeso" &&  (2023 - it.edad) in 1990..1999 } == personas.tam
}

/**
 * Encuentre y retorne las cédulas de aquellas mujeres con un nivel de estudio
 * universitario que tienen un peso superior al peso de la persona cuya cédula
 * se recibe como parámetro
 */
fun ejercicio7(personas: Lista<Persona>, cedula: Int): Lista<Int> {
    val persona = personas.encontrarElPrimeroQueCumple { it.cedula==cedula }
    return personas.filtrar { it.genero=='M' && it.nivelEducativo == "UNIVERSITARIA" && it.peso > persona!!.peso  }
            .transformar { it.cedula }
}

/**
 * Determine si la persona más alta de la lista es hombre de peso normal que usa lentes
 */
fun ejercicio8(personas: Lista<Persona>): Boolean {
    val perMasAlta = personas.encontrarMayor { it.altura }
    return perMasAlta!!.genero == 'H' && perMasAlta!!.nivelDePeso() == "normal" && perMasAlta!!.usaLentes
}

/**
 * Determine si el promedio de ingresos de hombres con nivel educativo universitario
 * es superior al promedio de ingresos de las mujeres con nivel educativo universitario
 */
fun ejercicio9(personas: Lista<Persona>): Boolean {
    val inH = personas.filtrar { it.genero == 'H' && it.nivelEducativo == "UNIVERSITARIA" }
    val ing: (Persona) -> Int = {it.ingresos}
    val sumH = inH.sumar(ing)
    val promH = sumH.toDouble() / inH.tam

    val inM = personas.filtrar { it.genero == 'M' && it.nivelEducativo == "UNIVERSITARIA" }
    val sumM = inM.sumar(ing)
    val promM = sumM.toDouble() / inM.tam

    return (promH > promM)
}
