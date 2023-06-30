package ean.estructuradedatos.taller

class Persona (var cedula: Int, var apellidos: String, var nombres: String, var edad: Int){}

fun persona(lista: List<Persona>, apellido: String): List<String>{
    val listaDeNombres = mutableListOf<String>()
    val cantidadDePersonas = lista.size
    var pos = 0

    fun buscarNombresDePersonas(personas: List<Persona>, apellido: String, siglo: Int): List<String> {
        if (pos < cantidadDePersonas) {
            val persona = lista.first()
            val siglos = Math.ceil(persona.edad.toDouble() / 100).toInt()
            if (persona.apellidos == apellido && persona.edad / 100 == siglos) {
                listaDeNombres.add(persona.nombres)
            }
            pos++
            buscarNombresDePersonas(personas, apellido, siglo)
        }
        return persona(lista,apellido)
    }
    return listaDeNombres
}


//-----------------------------------------------------------------

Escriba aquí el código en Kotlin correspondiente al segundo punto del quiz.

Su respuesta:
class Persona (var cedula: Int, var apellidos: String, var nombres: String, var edad: Int){}

fun persona(lista: List<Persona>, apellido: String): List<String> {
    val listaDeNombres = mutableListOf<String>()
    val cantidadDePersonas = lista.size
    var pos = 0

    fun buscarNombresDePersonas(personas: List<Persona>, apellido: String, siglo: Int): List<String> {
        if (pos < cantidadDePersonas) {
            val persona = lista.first()
            val siglos = Math.ceil(persona.edad.toDouble() / 100).toInt()
            if (persona.apellidos == apellido && persona.edad / 100 == siglo) {
                listaDeNombres.add(persona.nombres)
            }
            pos++
            buscarNombresDePersonas(lista, apellido)
        }
    }
    persona(listaDeNombres, apellido)
    return listaDeNombres
}
