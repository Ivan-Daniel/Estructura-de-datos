/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Listas en Kotlin
 * Autor: Universidad EAN - 23 de febrero de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller07

/**
 * Información que mantenemos de una persona
 */
data class Persona(
    val cedula: Int,
    val edad: Int,
    val genero: String,             // "M" para masculino, "F" para Femenino
    val hijos: Int,
    val nivelEducativo: String,     // PRIMARIA, SECUNDARIA, PREGRADO, POSTGRADO
    val estrato: Int,
    val ingresos: Int,
    val peso: Int,                  // Peso en kilos
    val altura: Int,                // altura en centímetros
    val fuma: Boolean,
    val tieneLentes: Boolean,
    val tieneCasa: Boolean,
    val tieneAutomovil: Boolean
) {
    /**
     * Este método obtiene el año de nacimiento de la persona en el 2023
     */
    fun añoNacimiento(): Int = 2023 - edad

    /**
     * Método que retorna el impuesto que debe pagar la persona.
     * Si la persona es de estrato 1 o 2, este impuesto corresponde al 5% de los ingresos
     * Para los otros estratos corresponde a la décima parte del ingreso más 10 mil pesos
     * multiplicado por el estrato
     */
    fun impuesto(): Double {
        return when (estrato) {
            1,2 -> ingresos*0.05
            else -> (ingresos/10.0) + 10_000*estrato
        }
    }
}

//-----------------------------------------------------------------------------
// Operaciones a llevar a cabo
//-----------------------------------------------------------------------------

fun contarMujeresConAutomovil(personas: List<Persona>): Int {
    var cont = 0
    for (p in personas){
        if (p.genero == "F" && p.tieneAutomovil) {
            cont ++
        }
    }
    return cont
}

/**
 * Contar el número de personas que pesan entre 60 y 80 kilos
 */
fun ejercicio1a(personas: List<Persona>): Int {
    var cont = 0
    for (p in personas){
        if (p.peso in 60..80) {
            cont ++
        }
    }
    return cont
}

/**
 * Determinar si la cantidad de mujeres es superior a la cantidad de hombres
 * El método deberá retornar true si hay más mujeres que hombres y false
 * en caso contrario.
 */
fun ejercicio1b(personas: List<Persona>): Boolean {
    var cantM= 0
    var cantH= 0
    var validar:Boolean=true
    for (persona in personas){
        if (persona.genero == "F"){
            cantM
        }
        if (persona.genero == "M"){
            cantH
        }
        if (cantM > cantH){
            validar
        } else validar = false
    }
    return validar
}

/**
 * Encontrar la suma de los ingresos de aquellas personas
 * que no fuman y que sean mayores de 50 años de edad
 */
fun ejercicio2a(personas: List<Persona>): Int {
    var sumaI = 0
    for (persona in personas){
        if (!persona.fuma && persona.edad > 50) {
            sumaI += persona.ingresos
        }
    }
    return sumaI
}

/**
 * Escriba una función que retorne la suma de los pesos
 * de las personas de genero femenino, cuyo cédula es par
 * y no tiene hijos
 */
fun ejercicio2b(personas: List<Persona>): Int {
    var sumaP = 0
    for (persona in personas){
        if (persona.genero == "F" && persona.cedula % 2 ==0 && persona.hijos==0){
            sumaP += persona.peso
        }
    }
    return sumaP
}

/**
 * Escriba una función que retorne el promedio de edad
 * de los hombres que se ganan entre 2 y 3 millones
 */
fun ejercicio3a(personas: List<Persona>): Double {
    var sumaEdad = 0
    var numHombres = 0.0

    for (persona in personas) {
        if (persona.genero == "M" && persona.ingresos in 2_000_000 .. 3_000_000) {
            numHombres++
            sumaEdad += persona.edad
        }
    }
    return sumaEdad / numHombres
}

/**
 * ¿Cual es el promedio de ingresos de aquellas personas que tienen una
 * altura inferior a 170 centímetros, y que pesan entre 80 y 90 kilos
 * y no fuman ni usan lentes y cuyo nivel educativo sea igual al que
 * se pasa como parámetro
 */
fun ejercicio3b(personas: List<Persona>, nivel: String): Double {
    var cantP = 0
    var sumaIn= 0.0

    for (persona in personas){
        if (persona.altura < 170 && persona.peso in 80..90 && !persona.fuma && !persona.tieneLentes && persona.nivelEducativo == nivel) {
            cantP ++
            sumaIn += persona.ingresos

        }
    }
    return sumaIn / cantP
}

/**
 * Cuál es el porcentaje de mujeres que viven en estrato 1, 2 o 3 y que tienen casa
 */
fun ejercicio3c(personas: List<Persona>): Double {
    var cantM = 0.0
    for (persona in personas){
        if (persona.genero == "F" && (persona.estrato in 1..3) && persona.tieneCasa){
            cantM ++
        }
    }
    return cantM / personas.size * 100
}

/**
 * Hallar el indice de masa corporal de una persona
 * Este indice se halla p / h^2, donde p es el peso en kilos, y h es la altura
 * en metros.
 */
fun imc(persona: Persona): Double  {
    var alturaM = persona.altura / 100.0
    var masaC = persona.peso/ (alturaM * alturaM)
    return masaC
}

/**
 * El nivel de peso de una persona depende del imc de esa persona
 * de acuerdo a la siguiente:
 * nivel = "Bajo peso" cuando el imc está por debajo de 18.5
 * nivel = "Normal" cuando el imc está entre 18.5 y 24.9
 * nivel = "Sobrepeso" cuando el imc está entre 25.0 y 29.9
 * nivel = "Obesidad" cuando el imc es 30.0 o superior
 * Escriba una función que halle el nivel de peso de una persona
 * USE LA FUNCIÓN IMC HECHA ANTERIORMENTE
 */
fun nivelPeso(p: Persona): String {
    var imc = imc(p)
    return when {
        imc < 18.5 -> "Bajo peso" //cuando el imc está por debajo de 18.5
        imc < 25.0 -> "Normal" //cuando el imc está entre 18.5 y 24.9
        imc < 30.0 -> "Sobrepeso" //cuando el imc está entre 25.0 y 29.9
        else  -> "Obesidad" //cuando el imc es 30.0 o superior
    }
}

/**
 * Halle el promedio de edad de los hombres obesos
 */
fun ejercicio3d(personas: List<Persona>): Double {
    var sumE= 0.0
    var cantOb= 0

    for (persona in personas){
        if (persona.genero == "M" && nivelPeso(persona) == "Obesidad"){
            sumE += persona.edad
            cantOb ++
        }
    }
    return sumE / cantOb
}

/**
 * Hallar la cédula de la mujer más alta
 */
fun ejercicio4a(personas: List<Persona>): Int {
    var altura =0
    var cedula = 0
    for (persona in personas) {
        if (persona.genero == "F") {
            if (persona.altura > altura){
                altura = persona.altura
                cedula = persona.cedula
            }
        }
    }
    return cedula
}

/**
 * Escriba una función que retorne la cédula del hombre
 * mayor de 30 años que tiene los ingresos más bajos
 **/
fun ejercicio4b(personas: List<Persona>): Int {
    var cedula = 0
    var ingresos = 10_000_000
    for (persona in personas) {
        if (persona.genero == "M" && persona.edad > 30){
            if (persona.ingresos < ingresos) {
                ingresos = persona.ingresos
                cedula = persona.cedula
            }
        }
    }
    return cedula
}

/**
 * Escriba una función que retorne la lista de las
 * cédulas de aquellas mujeres que no tienen casa
 * no tienen hijos y tienen un nivel de peso normal
 */
fun ejercicio05(personas: List<Persona>): List<Int> {
    var resultado = mutableListOf<Int>()

    for (p in personas) {
        if (p.genero == "F" && !p.tieneCasa && p.hijos == 0  &&
            nivelPeso(p) == "Normal"){
            resultado.add(p.cedula)
        }
    }
    return resultado
}

/**
 * Escriba una función que retorne una lista con las personas
 * que pagan menos de 250 mil pesos en impuesto pero que tiene
 * carro y que viven en estrato 4 y tienen un pregrado o un
 * postgrado
 */
fun ejercicio05b(personas: List<Persona>): List<Persona> {
    var resultado = mutableListOf<Persona>()

    for (persona in personas) {
        if (persona.impuesto() < 250_000 && persona.tieneAutomovil && persona.estrato == 4 &&
            (persona.nivelEducativo == "PREGRADO" || persona.nivelEducativo == "POSTGRADO")) {
            resultado.add(persona)
        }
    }
    return resultado
}

/**
 * Escriba una función que retorne cuál de los 4 estratos tiene la mayor
 * cantidad de hombres.
 */

fun ejercicio06(personas: List<Persona>): Int {
    var estrato1 = 0
    var estrato2 = 0
    var estrato3 = 0
    var estrato4 = 0
    var resultado = 0

    for (persona in personas) {
        if (persona.genero == "M" && persona.estrato == 1) {
           estrato1 ++
        }
    }
    for (persona in personas) {
        if (persona.genero == "M" && persona.estrato == 2) {
            estrato2 ++
        }
    }
    for (persona in personas) {
        if (persona.genero == "M" && persona.estrato == 3) {
            estrato3 ++
        }
    }
    for (persona in personas) {
        if (persona.genero == "M" && persona.estrato == 4) {
            estrato4 ++
        }
    }

    if (estrato1 > estrato2 && estrato1 > estrato3 && estrato1 > estrato4) resultado = 1
    else if (estrato2 > estrato1 && estrato2 > estrato3 && estrato2 > estrato4) resultado = 2
    else if (estrato3 > estrato1 && estrato3 > estrato2 && estrato3 > estrato4) resultado = 3
    else if (estrato4 > estrato1 && estrato4 > estrato2 && estrato4 > estrato3) resultado = 4

    return resultado
}
