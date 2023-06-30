/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Unidad de Estudios: Estructura de Datos
 * Faculta de Ingeniería
 *
 * Proyecto Banco
 * Fecha: Mayo 23, 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package bancos

import ean.colecciones.Diccionario
import ean.colecciones.Lista
import ean.colecciones.diccionarioVacio
import ean.colecciones.listaVacia

/**
 * Clase que representa un Banco.
 */
class Banco() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Diccionario con los diversos clientes del banco
     */
    private val clientes: Diccionario<Int, Cliente> = diccionarioVacio()

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Permite obtener el número de clientes que hay en el banco
     */
    fun darCantidadClientes(): Int {
 // !! por si retorna null
        return clientes.tam
    }

    /**
     * Método para agregar un cliente al Banco
     * No pueden haber dos clientes con la misma cédula. Si el cliente ya
     * existe, se retorna false.
     * Si no existe la cédula del cliente, se crea el objeto Cliente con
     * los datos de entrada, y se agrega el nuevo cliente al diccionario.
     * Tenga en cuenta que la llave es la cédula
     */
    fun abrirCuenta(cedula: Int, edad: Int, deAhorros: Boolean): Boolean {
        return if (clientes.llaves.contains(cedula)){                // contanis es igual a equals
            false
        } else{
            clientes.agregar(cedula,Cliente(cedula,edad,deAhorros) ) //llave es "cedula"
            true
        }
    }

    /**
     * Permite obtener la información del cliente que tiene la cédula
     * NO PUEDE HABER UN FOR para encontrar el cliente!
     * Si no hay un cliente con esa cédula, se retorna null
     */
    fun darCliente(cedula: Int): Cliente? {
        return clientes[cedula]
    }

    /**
     * Obtiene el saldo de la cuenta del cliente que tiene
     * la cédula dada.
     * Prerrequisito: La cédula existe en el banco
     */
    fun darSaldoCliente(cedula: Int): Int {
        require (clientes.llaves.contains(cedula))
        return clientes[cedula]!!.darSaldo()
    }

    /**
     * Deposita un dinero en la cuenta del cliente con la cedula dada.
     * Si no existe un cliente con esa cédula se debe retornar false
     * Debe tener las consideraciones establecidas en el enunciado
     * de retirar de la clase Cliente. Se retorna true si se pudo
     * hacer el depósito y false si no fue posible.
     */
    fun depositarDineroCuentaCliente(cedulaCliente: Int, dinero: Int): Boolean {
        if (!clientes.llaves.contains(cedulaCliente)){
            return false
        }
        return if(clientes[cedulaCliente]!!.depositar(dinero)){
            true
        }else false
    }

    /**
     * Retira un dinero de la cuenta del cliente con la cédula dada
     * OJO: Si no existe el cliente con cédula dada, se retorna false
     * Debe usarse el método retirar de la clase Cliente.
     */
    fun retirarDineroCuentaCliente(cedulaCliente: Int, dinero: Int): Boolean {
        if (!clientes.llaves.contains(cedulaCliente)){
            return false
        }
        return if(clientes[cedulaCliente]!!.retirar(dinero)){
            true
        }else false
    }

    /**
     * Esta operación transfiere dinero de una cuenta de origen a una cuenta de destino.
     * Una transferencia consiste en retirar dinero del origen y depositarlo en el destino.
     * A tener en cuenta: se debe retornar false y no debe haber cambio en los saldos de
     * las cuentas si ocurre alguna de los siguientes casos
     * - los clientes de origen o de destino no existen
     * - El dinero es cero o negativo
     * - Si la cuenta de origen es de ahorros y el saldo no es suficiente para retirar el dinero
     * En cualquier otro caso se debe hacer la transferencia y retornar true
     */
    fun transferirDineroEntreClientes(clienteOrigen: Int, clienteDestino: Int, dinero: Int): Boolean {
        if (clienteOrigen == null || clienteDestino == null || dinero<=0){
            return false
        }
        if(clientes[clienteOrigen]!!.deAhorros && clientes[clienteOrigen]!!.darSaldo() < dinero){
            return false
        }

        clientes[clienteOrigen]!!.retirar(dinero)
        clientes[clienteDestino]!!.depositar(dinero)

        return true
    }

    /**
     * Obtener la lista de las cedulas de aquellos
     * clientes que tengan cuentas de ahorros con
     * algún dinero en la cuenta.
     */
    fun cuentasAhorroSaldoPositivo(): Lista<Int> {
        val listCC = listaVacia<Int>()
        for (n in clientes.llaves){
            if (clientes[n]!!.deAhorros && clientes[n]!!.darSaldo() > 0) {
                listCC.agregarAlFinal(clientes[n]!!.cedula)
            }
        }
        return listCC
    }

    /**
     * Obtiene el cliente que tiene una cuenta del tipo dado con
     * el saldo más grande. tipo puede ser CORRIENTE para cuentas
     * corrientes y AHORROS para cuenta de ahorros. Debe retornarse
     * null si no hay cuenta en el banco con el tipo dado.
     */
    fun cuentaConMayorSaldo(tipo: String): Cliente? {
        var clientems: Cliente? = null
        var maxSaldo = Int.MIN_VALUE

        for (n in clientes.llaves){
            if (clientes[n]!!.deAhorros && tipo == "AHORROS" || !clientes[n]!!.deAhorros&& tipo == "CORRIENTE"){
                if (clientes[n]!!.darSaldo() > maxSaldo) {
                    maxSaldo = clientes[n]!!.darSaldo()
                    clientems = clientes[n]!!
                }
            }
        }
        return clientems
    }

    /**
     * Obtener la cantidad de clientes menores de edad que
     * hay en el banco.
     */
    fun menoresEdad(): Int {
        var c = 0
        for (n in clientes.llaves){
            if (clientes[n]!!.edad in 1..17){
                c++
            }
        }
        return c
    }

    /**
     * Deposita en las cuentas de ahorro el interés mensual siempre y cuando
     * tengan el saldo mínimo que se pasa como dato de entrada.
     * Este interés corresponde a un 10% del saldo actual.
     * Retorne la suma de los saldos de las cuentas a quienes
     * se le depositó los intereses
     */
    fun depositarIntereses(saldoMinimo: Int): Int {
        var c = 0
        for (n in clientes.llaves){
            if (clientes[n]!!.deAhorros && clientes[n]!!.darSaldo() >= saldoMinimo){
                val interes = (clientes[n]!!.darSaldo() * 0.1).toInt()
                clientes[n]!!.depositar(interes)
                c += clientes[n]!!.darSaldo()
            }
        }
        return c
    }
}