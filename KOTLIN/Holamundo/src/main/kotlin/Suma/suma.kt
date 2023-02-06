package Suma
fun main() {
    print("Ingrese el primer valor: ")
    val a = readLine()!!.toInt()
    print("Ingrese el segundo valor: ")
    val b = readLine()!!.toInt()
    val suma = a + b
    println("la suma de $a entre $b es $suma")
}
