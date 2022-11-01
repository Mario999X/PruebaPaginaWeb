import utils.DirController
import utils.SOController
import java.io.File
import java.nio.file.Paths

private lateinit var pB: Process
private lateinit var reader: String

private val FS = File.separator

fun main() {
    val comprobador = SOController.init()
    DirController.init()

    val userDir = System.getProperty("user.dir")
    val pathJar = Paths.get(userDir + FS + "build" + FS + "libs")
    val pathData = Paths.get(userDir + FS + "data")

    val file = File(pathData.toString() + FS + "prueba.html")

    print("Introduzca una direccion HTML: ")
    val url = readln()

    if (!comprobador) {

        pB = ProcessBuilder("cmd.exe", "/c", "cd $pathJar & java -jar PruebaPaginaWeb-1.0.jar $url").start()
        reader = pB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        //println(reader)

        /* while (reader.readLine().also { line = it } != null) {
           println(line)}
           // Con estos cambios (creacion de un String? line | dejando a reader en buffered) podemos
           leer lo sacado por terminal linea a linea
           */

        println("HTML leido correctamente")
        file.writeText(reader)
        println("HTML escrito correctamente en $pathData")

    } else {

        pB = ProcessBuilder("bash", "-c", "cd $pathJar && java -jar PruebaPaginaWeb-1.0.jar $url").start()
        reader = pB.inputStream.bufferedReader().lineSequence().joinToString("\n")
        //println(reader)

        println("HTML leido correctamente")
        file.writeText(reader)
        println("HTML escrito correctamente en $pathData")
    }
}