package taller02

import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Un número complejo consta de una parte real y una parte imaginaria
 */
class NumeroComplejo(var parteReal: Double, var parteImaginaria: Double) {
    // Halla el valor absoluto del número complejo
    fun valorAbsoluto(): Double {
        return sqrt(this.parteReal.pow(2)+parteImaginaria.pow(2))
    }

    // Halla la fase o argumento del número complejo
    fun argumento()= atan(parteImaginaria/parteReal)

    // Halla el inverso o recíproco de un número complejo
    fun inverso(): NumeroComplejo {
        val d= parteReal.pow(2)+parteImaginaria.pow(2)
        val pri = parteReal/d
        val pii= parteImaginaria/d
        return NumeroComplejo(pri,-pii)
    }

    // Multiplica la parte real y la parte imaginaria por un escalar
    fun productoPorEscalar(escalar: Double) {
        parteReal*=escalar
        parteImaginaria*=escalar
    }

    // Obtiene una versión String del número complejo
    override fun toString(): String {
        return String.format("%.2f + (%.2f)i", parteReal, parteImaginaria)
    }
}

// Función externa que halla la suma de dos números complejos
fun sumarNumComplejos(num1: NumeroComplejo, num2: NumeroComplejo): NumeroComplejo {
    var a= num1.parteReal
    var b = num1.parteImaginaria
    var c= num2.parteReal
    var d= num2.parteImaginaria

    return NumeroComplejo(a+c,b+d)
}

// -----------------------------------------------------------------------------------

// Clase Producto
class Producto(val nombre: String,
               val tipo: String,
               var valorUnitario: Double,
               var cantidadBodega: Int,
               val cantidadMinima: Int) {
    // Retornar el IVA correspondiente al producto. Ojo: este IVA depende del tipo de producto.
    fun darIVA(): Double {
        var iva =0.0
       if (tipo.equals("papeleria")){ iva= 0.16}
       if (tipo.equals("supermercado")){iva=0.04}
       if (tipo.equals("drogueria")){iva=0.12}
        return iva
    }

    //  Calcula el valor final del producto, incluyendo el IVA.
    fun calcularPrecioFinal(): Double {
        var x= this.darIVA()*valorUnitario
        var valor_final= x+valorUnitario
        return valor_final
    }

    // Vende la cantidad de unidades dada por parámetro.
    fun vender(cantidad: Int) {
     if (cantidadBodega>cantidad || cantidadBodega==cantidad){
         cantidadBodega-=cantidad
     } else cantidadBodega=0    
    }

    // Aumenta la cantidad de unidades en bodega del producto en la cantidad que se recibe como dato de entrada.
    fun abastecer(cantidad: Int) {
        cantidadBodega+=cantidad
    }

    // retorna True sin la cantidad en Bodega es menor que la cantidad mínima, y False en caso contrario.
    fun puedeAbastecer(): Boolean {
        if (this.cantidadBodega<this.cantidadMinima){
            return true
        } else return false
    }

    // Obtener una representación visual de un producto.
    override fun toString(): String {
        return "Producto(nombre='$nombre', tipo='$tipo', valorUnitario=$valorUnitario, cantidadBodega=$cantidadBodega, cantidadMinima=$cantidadMinima)"
    }
}