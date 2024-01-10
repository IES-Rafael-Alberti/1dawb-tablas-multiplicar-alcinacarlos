/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min:Int, max:Int):Int{
    println("Introduzca un número entre el $min y el $max: ")
    val num = readln().toIntOrNull()
    if (num == null || num > max || num < min){
        println("**Error** Número no válido (pulsa ENTER para continuar...)")
        readln()
        return pedirNum(min, max)
    }
    return num
}

/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(text: String): Boolean {
    println(text)
    val respuesta = readln()
    return when (respuesta) {
        "s", "si" -> true
        "n", "no" -> false
        else -> {
            println("**Respuesta no válida** (pulsa ENTER para continuar...)")
            readln()
            pregunta(text)
        }
    }
}

fun main() {
    //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su table de multiplicar...
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"
    var respuesta = true
    while (respuesta){
        val num = pedirNum(1, 100)
        println("La tabla de multiplicar del número $num es: ")
        for(i in 1..10){
            println("$i -> $num x $i = ${i*num}")
        }
        respuesta = pregunta("¿Desea generar otra tabla de multiplicación? (s/n)")
    }

}