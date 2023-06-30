package taller19

import ean.colecciones.Lista

class Empleado (var cedula: Int, var nombre: String, var apellido: String, var añoNacimiento: Int, var cargo:String, var sueldo: Int)

fun pnto1 (emp: Lista<Empleado>): Pair<Int, String> {
    //a.
    val emFilt = emp.filtrar { it.cargo == "contador" && (2023 - it.añoNacimiento) >= 100 && !it.apellido.endsWith("Z") || !it.apellido.endsWith("M") ||
            !it.apellido.endsWith("A") ||!it.apellido.endsWith("E") ||!it.apellido.endsWith("I") ||!it.apellido.endsWith("O") ||!it.apellido.endsWith("U") }
    val oper: (Empleado) -> Double = {(2023 - it.añoNacimiento).toDouble()}
    val sum =emFilt.sumar(oper)
    val prom = sum/emFilt.tam

    //b.
    val empViejo = emp.filtrar { it.cargo != "celador" && it.cargo != "asistente" && it.sueldo % 1_000_000 == 0 }
    val emV= empViejo.encontrarMayor{it.añoNacimiento}
    val nomyAp = emV?.nombre + " " + emV?.apellido + ""

    return Pair(prom.toInt(),nomyAp)
}

fun pnto2 (emp: Lista<Empleado>):Lista<Int>{
    val list1 = emp.filtrar { it.sueldo < 1_000_000 && it.añoNacimiento % 4 == 0 && (it.añoNacimiento % 100 != 0 || it.añoNacimiento % 400 == 0)  }
    return list1.transformar { it.cedula }
}