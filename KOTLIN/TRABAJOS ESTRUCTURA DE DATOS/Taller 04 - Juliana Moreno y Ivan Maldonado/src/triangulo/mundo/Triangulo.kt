/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Triangulo
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package triangulo.mundo

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Clase que representa un triángulo.
 */
class Triangulo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer punto del triángulo.
     */
    private val punto1: Punto = Punto(200.0, 50.0)

    /**
     * Segundo punto del triángulo.
     */
    private val punto2: Punto = Punto(300.0, 200.0)

    /**
     * Tercer punto del triángulo.
     */
    private val punto3: Punto = Punto(100.0, 200.0)

    /**
     * Color de las líneas.
     */
    private val colorLineas: Color = Color(60, 168, 56)

    /**
     * Color del relleno.
     */
    private val colorRelleno: Color = Color(0, 83, 24)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el punto 1 del triángulo.
     * @return Punto 1.
     */
    fun darPunto1(): Punto {
        return punto1
    }

    /**
     * Retorna el punto 2 del triángulo.
     * @return Punto 2.
     */
    fun darPunto2(): Punto {
        return punto2

    }

    /**
     * Retorna el punto 3 del triángulo.
     * @return Punto 3.
     */
    fun darPunto3(): Punto {
        return punto3
    }

    /**
     * Retorna el color de las líneas del triángulo.
     * @return Color de las líneas.
     */
    fun darColorLineas(): Color {
        return colorLineas
    }

    /**
     * Retorna el color del relleno del triángulo.
     * @return Color del relleno.
     */
    fun darColorRelleno(): Color {
        return colorRelleno
    }

    /**
     * Retorna el perímetro del triángulo.
     * @return Perímetro del triángulo.
     */
    fun darPerimetro(): Double {
        return calcularLado1()+ calcularLado2()+ calcularLado3()
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br></br>
     * @return Área del triángulo.
     */
    fun darArea(): Double {
        return darPerimetro()/2
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br></br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     * @return Altura del triángulo.
     */
    fun darAltura(): Double {
        var base= calcularLado1()
        var altura= (2*darArea())/base
        return altura
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    private fun calcularLado1(): Double = sqrt((punto2.darX()-punto1.darX()).pow(2)+(punto2.darY()-punto1.darY()).pow(2))

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    private fun calcularLado2(): Double = sqrt((punto3.darX()-punto2.darX()).pow(2)+(punto3.darY()-punto2.darY()).pow(2))

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    private fun calcularLado3(): Double = sqrt((punto1.darX()-punto3.darX()).pow(2)+(punto1.darY()-punto3.darY()).pow(2))

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     * @param pX1 Coordenada X del vértice de referencia.
     * @param pY1 Coordenada Y del vértice de referencia.
     * @param pX2 Coordenada X del vértice opuesto 1.
     * @param pY2 Coordenada Y del vértice opuesto 1.
     * @param pX3 Coordenada X del vértice opuesto 2.
     * @param pY3 Coordenada Y del vértice opuesto 2.
     * @return Ángulo opuesto entre vértice de referencia y los otros dos vértices.
     */
    fun calcularAnguloOpuesto(pX1: Double, pY1: Double, pX2: Double, pY2: Double, pX3: Double, pY3: Double): Double {
        // Ángulo 1
        var angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1)

        // Ángulo 2
        var angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1)

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = if (angulo1 < 0) angulo1 + 2.0 * Math.PI else angulo1
            angulo2 = if (angulo2 < 0) angulo2 + 2.0 * Math.PI else angulo2
        }

        // Calcula el ángulo opuesto
        var anguloOpuesto = (angulo1 + angulo2) / 2.0 + Math.PI
        anguloOpuesto = anguloOpuesto % (2.0 * Math.PI)
        return anguloOpuesto
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto1(pX: Double, pY: Double) {
        this.punto1.cambiarX(pX)
        this.punto1.cambiarY(pY)
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto2(pX: Double, pY: Double) {
        this.punto2.cambiarX(pX)
        this.punto2.cambiarY(pY)
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto3(pX: Double, pY: Double) {
        this.punto3.cambiarX(pX)
        this.punto3.cambiarY(pY)
    }

    /**
     * Cambia el color de relleno del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorRelleno(pRojo: Int, pVerde: Int, pAzul: Int) {
        this.colorRelleno.cambiarRojo(pRojo)
        this.colorRelleno.cambiarVerde(pVerde)
        this.colorRelleno.cambiarAzul(pAzul)
    }

    /**
     * Cambia el color de la líneas del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorLineas(pRojo: Int, pVerde: Int, pAzul: Int) {
        this.colorLineas.cambiarRojo(pRojo)
        this.colorLineas.cambiarVerde(pVerde)
        this.colorLineas.cambiarAzul(pAzul)
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Permite obtener el tipo del triángulo
     * "equilátero" si los tres lados son iguales
     * "isosceles" si dos lados son iguales
     * "escaleno" si los tres lados son diferentes
     */
    fun tipo(): String {
        var t= ""

        if(calcularLado1().toInt()==calcularLado2().toInt()&&calcularLado2().toInt()==calcularLado3().toInt())t="equilátero"
        else if(calcularLado1().toInt()==calcularLado2().toInt()&&calcularLado2().toInt()!=calcularLado3().toInt())t="isosceles"
        else if (calcularLado1().toInt()==calcularLado3().toInt()&&calcularLado3().toInt()!=calcularLado2().toInt())t="isosceles"
        else if (calcularLado2().toInt()==calcularLado3().toInt()&&calcularLado3().toInt()!=calcularLado1().toInt())t="isosceles"
        else t="escaleno"
        return t
    }

    /**
     * Permite obtener el punto en el centro del triángulo, conocido como el centroide
     */
    fun centroide(): Punto {
        var centrox = (this.punto1.darX()+this.punto2.darX()+this.punto3.darX())/3
        var centroy = (this.punto1.darY()+this.punto2.darY()+this.punto3.darY())/3
        return Punto(centrox, centroy)
    }


    }
/**
 * Permite obtener el punto que se encuentra en el incentro del triángulo t
 * El incentro es el punto donde las bisectrices de los tres ángulos internos
 * se intersecan.
 * https://www.neurochispas.com/wiki/incentro-de-un-triangulo-definicion-formulas-y-ejemplos/
 */
fun incentro(t: Triangulo): Punto {
    var ax = t.darPunto1().darX()
    var bx = t.darPunto2().darX()
    var cx = t.darPunto3().darX()
    var ay = t.darPunto1().darY()
    var by = t.darPunto2().darY()
    var cy = t.darPunto3().darY()
    var suma =t.darPerimetro()
    var sx= ax+bx+cx
    var sy= ay+by+cy

    return Punto(sx/suma, sy/suma)
}


