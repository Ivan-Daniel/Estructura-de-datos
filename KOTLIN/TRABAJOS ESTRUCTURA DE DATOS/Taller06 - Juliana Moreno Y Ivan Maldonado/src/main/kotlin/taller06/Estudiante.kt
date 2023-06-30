/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * <p>
 * Estructura de Datos - Taller 06
 * Ejercicio: El Estudiante
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller06

class Estudiante(
    val codigo: Int = 1001001001,       // Código del estudiante.
    val nombre: String = "Juliana",     // Nombre del estudiante.
    val apellido: String = "Ramírez"    // Apellido del estudiante.
) {
    // -----------------------------------------------------------------
    // Atributos Adicionales
    // -----------------------------------------------------------------
    var cursos: List<Curso> = emptyList()

    // -----------------------------------------------------------------
    // Métodos Contadores
    // -----------------------------------------------------------------

    /**
     * Determine cuántos cursos tienen un número de créditos par
     */
    fun cursosCodigoPar(): Int {
        var cont =0
        // recorrer
        for (curso in this.cursos){
            if (curso.creditos % 2 == 0) {
                cont ++
            }
        }
        //retorna contador
        return cont
    }

    /**
     * Determinar y retornar el número de cursos de pregrado que están
     * calificados y cuya carrera sea Sistemas o Ciencia
     */
    fun ejercicio02(): Int {
        //return cursos.count { it.estaCalificado() && (it.carrera == "Sistemas" || it.carrera == "Ciencias") }

        var cont =0
        // recorrer
        for (curso in this.cursos){
            if (((!(curso.dePostgrado)) && curso.estaCalificado()) && ((curso.carrera == "Sistemas") || (curso.carrera == "Ciencias")))  {
                cont ++
            }
        }
        //retorna contador
        return cont
    }

    /**
     * Determinar y retornar la cantidad de cursos del estudiante que
     * pertenecen a la carrera que se recibe como parámetro y tienen
     * un número de créditos entre 2 y 4.
     */
    fun ejercicio03(carrera: String): Int {
        var canCursos =0
        // recorrer
        for (curso in this.cursos){
            if (curso.carrera == carrera && curso.creditos in 2..4) {
                canCursos ++
            }
        }
        //retorna contador
        return canCursos
    }

    /**
     * Determinar y retornar cuántos cursos que están calificados
     * fueron aprobados por el estudiante
     */
    fun ejercicio04(): Int {
        var aprovado =0
        // recorrer
        for (curso in this.cursos){
            if (curso.estaCalificado() && curso.aproboCurso()) {
                aprovado ++
            }
        }
        //retorna contador
        return aprovado
    }

    /**
     * Determine y retorne cuantos cursos de pregrado que pertenecen
     * a la carrera que se pasa como parámetro, están calificados
     * y tienen una nota por encima de 20, pero por debajo de 60.
     */
    fun ejercicio05(carrera: String): Int {
        var cursosP =0
        // recorrer
        for (curso in this.cursos){
            if (curso.carrera == carrera && curso.estaCalificado() && (curso.darNota() > 20) && (curso.darNota() < 60)) {
                cursosP ++
            }
        }
        //retorna contador
        return cursosP
    }

    /**
     * Halle la suma de los créditos de todos los cursos que tiene
     * el estudiante
     */
    fun ejercicio06(): Int {
        var sumC = 0
        // recorrer
        for (curso in this.cursos) {
            sumC += curso.creditos
        }
        //retorna contador
        return sumC
    }

    /**
     * Halle la suma de los créditos de aquellos cursos
     * que están calificados y que pertenecen a la carrera
     * que se pasa como parámetro y que fueron aprobados
     */
    fun ejercicio07(carrera: String): Int {
        var sumC =0
        // recorrer
        for (curso in this.cursos){
            if ( curso.carrera == carrera && curso.estaCalificado() && curso.aproboCurso()){
                sumC += curso.creditos
            }
        }
        //retorna contador
        return sumC
//        cursos.forEach {
//            if (it.carrera == carrera && it.estaCalificado() &&
//                it.aproboCurso()){
//                sumC += it.creditos
//            }
//        }
//        return sumC
    }

    /**
     * Obtener el promedio normal de las notas de
     * aquellos cursos que han sido calificados
     */
    fun ejercicio08(): Double {
        var sumanota=0.0
        var promedio=0.0
        var contcal=0
        for (curso in this.cursos){
            if ( curso.estaCalificado()){
                contcal++
            }
        }
        for (curso in this.cursos){
            if ( curso.estaCalificado()){
                sumanota+=curso.darNota()
                promedio= sumanota/contcal
            }
        }
        return promedio
    }

    /**
     * Calcula el promedio ponderado del estudiante de los cursos que tienen
     * nota asignada. Para hallar el promedio ponderado debe sumarse la
     * multiplicacion de la nota por los credito y dividirlo por la suma
     * de los créditos. Ojo: SOLO LOS QUE TIENEN NOTA
     */
    fun ejercicio09(): Double {
        var sumaP = 0.0
        var sumaCre = 0.0
        for (curso in this.cursos) {
            if (curso.estaCalificado()) {
                sumaP += curso.darNota() * curso.creditos
                sumaCre += curso.creditos
            }
        }
        return sumaP / sumaCre
    }

    /**
     * Determine y retorne el porcentaje de cursos aprobados
     * del estudiante. Debe ser un número entre 0 y 100
     */
    fun ejercicio10(): Double {
        var cantcursosaprobados=0.0
        var cantcursosnoaprobados=0.0
        var cursostotales=0.0
        var porcentajeaprob=0.0
        for (curso in this.cursos){
            if(curso.aproboCurso()){
                cantcursosaprobados++
            }
            if (!curso.aproboCurso()){
                cantcursosnoaprobados++
            }
            cursostotales=cantcursosaprobados+cantcursosnoaprobados
            porcentajeaprob=(cantcursosaprobados*100)/cursostotales
        }
        return porcentajeaprob
    }

    /**
     * Obtener y retornar el curso que tiene el código que
     * se pasa como parámetro. Si no existe el código en la
     * lista, deberá retornarse null
     */
    fun ejercicio11(codigo: String): Curso? {
        for (curso in this.cursos){
            if ( curso.codigo == codigo){
                return curso
            }
        }
        return null
    }

    /**
     * Escriba un método que retorne el código del
     * primer curso que pertenezca a la carrera que
     * se recibe como parámetro y que tiene el número
     * de créditos que se recibe también como parámetro.
     * Si no existe ese curso, deberá retornarse la
     * cadena vacía ("")
     */
    fun ejercicio12(carrera: String, creditos: Int): String {
        var x=""
        for (curso in this.cursos){
            if (curso.carrera==carrera && curso.creditos==creditos){
                x=curso.codigo.toString()
            } else x    }
        return x
    }

    fun notaMasAlta(): Double {
        var masAlta = cursos[0].darNota() //la nota
        for (curso in cursos){
            if (curso.darNota() > masAlta){
                masAlta = curso.darNota()
            }
        }
        return masAlta
    }
}