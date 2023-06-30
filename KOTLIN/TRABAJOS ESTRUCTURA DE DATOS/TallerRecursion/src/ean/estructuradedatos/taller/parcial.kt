package ean.estructuradedatos.taller

import ean.collections.IQueue
import ean.collections.TLinkedQueue

//punto 3

fun arcoseno(x: Double, i: Int): Double {
    return if (i == 0) {
        x
    } else {
        val term = (fact(2 * i)) / (Math.pow(2.0, 4.0 * 2.0 * i + 1) * fact(i) * fact(i))
        arcoseno(x, i - 1) + term
    }
}

fun fact(i: Int): Int {
    return if (i == 0) {
        1
    } else {
        i * fact(i - 1)
    }
}

//punto4
//punto a

data class Aeropuerto (val matricula: String, val numSillaOc: Int, val sillaLib: Int,
                       val gasolina: Double): Comparable<Aeropuerto> {

    override fun compareTo(other: Aeropuerto): Int {
        return if (gasolina < 1500 && numSillaOc == 0) 1 else 0 //1=SI 0=NO
    }
}

//punto b
data class infoAeropuerto (val nomAeropuerto: String, val nomCiudad: String,
                           val matricula: String? = null,
                           val operacion: String = "aterrizando", // o "despegando"
                           val paraDes: TLinkedQueue<infoAeropuerto>,
                           val paraAte: TLinkedQueue<infoAeropuerto>,
                           val cantMaxDes: Int,
                           val cantMaxAte: Int): Comparable<infoAeropuerto>{
    override fun compareTo(nomAeropuerto: String,nomCiudad: String): String {
        fun avionesEnTierra():Int{

        }
    }
}


// punto 5
fun buscarAeropuertoConMasAviones(
    aeropuertos: List<Aeropuerto>,
    ciudad: String
): Aeropuerto? {
    var aeropuertoConMasAviones: Aeropuerto? = null
    var maxAviones = 0
    for (aeropuerto in aeropuertos) {
        if (aeropuerto.ciudad == ciudad && esVocal(aeropuerto.nombre[0])) {
            val aviones = aeropuerto.avionesEsperandoDespegar
            if (aviones > maxAviones) {
                maxAviones = aviones
                aeropuertoConMasAviones = aeropuerto
            }
        }
        if (aeropuerto.subAeropuertos.isEmpty) {
            val subAeropuertoConMasAviones =
                buscarAeropuertoConMasAviones(aeropuerto.subAeropuertos, ciudad)
            if (subAeropuertoConMasAviones != null) {
                val aviones = subAeropuertoConMasAviones.avionesEsperandoDespegar
                if (aviones > maxAviones) {
                    maxAviones = aviones
                    aeropuertoConMasAviones = subAeropuertoConMasAviones
                }
            }
        }
    }
    return aeropuertoConMasAviones
}