package bancos

import ean.colecciones.Diccionario
import ean.colecciones.Lista
import ean.colecciones.diccionarioVacio
import ean.colecciones.listaVacia

class automovil (var placa: String, var marca: String, var modelo: Int, var precio: Int) {

    fun edadAuto():Int{
        val añosPasados = 2023 - modelo
        return if (modelo >= 2000 ){
            añosPasados
        } else{
            2*añosPasados+1
        }
    }
}

fun automoviles(automovil: Diccionario<String, automovil>,placa1: String, placa2: String, placa3: String): String? {
    var marcaMasVieja: String? = null
    var edadMasVieja = Int.MIN_VALUE

        if (automovil.llaves.contains(placa1) && automovil[placa1]!!.edadAuto() > edadMasVieja){
            edadMasVieja = automovil[placa1]!!.modelo
            marcaMasVieja = automovil[placa1]!!.marca
        }

         else if (automovil.llaves.contains(placa2) && automovil[placa2]!!.edadAuto() > edadMasVieja){
            edadMasVieja = automovil[placa2]!!.modelo
            marcaMasVieja = automovil[placa2]!!.marca
        }

        else if (automovil.llaves.contains(placa3) && automovil[placa3]!!.edadAuto() > edadMasVieja){
            marcaMasVieja = automovil[placa3]!!.marca
        }

    return marcaMasVieja
}

fun CoboSort(listaNumerosEnteros: Lista<Int>): Lista<Int> {
    val listaOrdenada = listaVacia<Int>()
    if (listaNumerosEnteros.tam > 0) {
        val listaCopia = listaNumerosEnteros.copiar()
        while (listaCopia.tam > 0) {
            var mayor = listaCopia[0]
            var indice = 0
            for (i in 0..listaCopia.tam - 1) {
                if (listaCopia[i] > mayor) {
                    mayor = listaCopia[i]
                    indice = i
                }
            }
            listaCopia.eliminar(indice)
            listaOrdenada.agregar(mayor, 0)
        }
    }
    return listaOrdenada

}
