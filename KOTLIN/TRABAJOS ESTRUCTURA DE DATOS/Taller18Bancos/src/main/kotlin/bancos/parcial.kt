package bancos

import ean.colecciones.Diccionario
import ean.colecciones.Lista
import ean.colecciones.diccionarioVacio
import ean.colecciones.listaVacia

class Proyecto (var codigo: String,
                var nombre: String,
                var cedula: Int,
                var puntaje1: Double,
                var puntaje2: Double,
                var puntaje3: Double,
                var tipoP: String,
                private var presupuesto: Int){

    fun conocerResultado():String{
         val anual =
             when (tipoP == "anual") {
                (puntaje1 >= 50.0 && puntaje2 >= 50.0 && puntaje3 >= 50.0) -> "APROBADO"
                 (puntaje1 >= 50.0 && puntaje2 < 50.0 && puntaje3 < 50.0 || puntaje1 < 50.0 && puntaje2 >= 50.0 && puntaje3 < 50.0 || puntaje1 < 50.0 && puntaje2 < 50.0 && puntaje3 >= 50.0) -> "APROBADO CON MODIFICACIONES"
                else ->"NO APROBADO"
            }
        val semestral =
             when(tipoP == "semestral") {
                (puntaje1 >= 60.0 && puntaje2 >= 60.0 && puntaje3 >= 60.0) -> "APROBADO"
                (puntaje1 >= 60.0 && puntaje2 < 60.0 && puntaje3 < 60.0 || puntaje1 < 60.0 && puntaje2 >= 60.0 && puntaje3 < 60.0 || puntaje1 < 60.0 && puntaje2 < 60.0 && puntaje3 >= 60.0) -> "APROBADO CON MODIFICACIONES"
                else -> "NO APROBADO"
            }

        return if (tipoP == "anual") return anual else semestral
    }

    fun puntajeProm (): Double {
        var c = 0
        val sum = puntaje1 + puntaje2 + puntaje3
        if ( sum > 0){
            c++
        }
        return sum / c.toDouble()
    }

    fun presupuestoAprovado():Double{
        if(conocerResultado() == "APROBADO" || conocerResultado() == "APROBADO CON MODIFICACIONES"){
             return (puntajeProm() * presupuesto) / 100.0
        }
        else  return 0.0
    }

    fun aumentarpresupuesto(porcentaje: Double):Double{
        if (presupuesto in 0..100){
           return presupuesto + porcentaje.toDouble()
        }
        else return 0.0
    }

    fun puntajeMasBajo():String{
        val anual =
            when (tipoP == "anual") {
                (puntaje1 < 50.0 && puntaje2 >= 50.0 && puntaje3 >= 50.0) -> "PRIMERO"
                (puntaje1 >= 50.0 && puntaje2 < 50.0 && puntaje3 >= 50.0)-> "SEGUNDO"
                else ->"TERCCERO"
            }
        val semestral =
            when (tipoP == "anual") {
                (puntaje1 < 60.0 && puntaje2 >= 60.0 && puntaje3 >= 60.0) -> "PRIMERO"
                (puntaje1 >= 60.0 && puntaje2 < 60.0 && puntaje3 >= 60.0)-> "SEGUNDO"
                else ->"TERCCERO"
            }
        return if (tipoP == "anual") return anual else semestral
    }
}

//a.
fun nomEstudiantes(proyecto: Diccionario<String, Proyecto>, cedula: Int):Lista<String>{
    val listNE = listaVacia<String>()
    for (n in proyecto.llaves){
        if (proyecto[n]!!.cedula == cedula && proyecto[n]!!.puntajeProm() < proyecto[n]!!.puntajeProm()) {
            listNE.agregarAlFinal(proyecto[n]!!.nombre)
        }
    }
    return listNE
}

//b.
fun pnto2 (emp: Lista<Proyecto>):Lista<Int>{
    val list1 = emp.filtrar { it.  }
    return list1.transformar { it.cedula }
}
