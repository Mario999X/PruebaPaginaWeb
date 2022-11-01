package utils

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object DirController {

    private val workingDir: String = System.getProperty("user.dir")
    private val dataPath = Paths.get(workingDir + File.separator + "data")

    fun init() {
        if (Files.isDirectory(dataPath) && Files.exists(dataPath)) {
            println("Carpeta data existe")
        } else {
            println("Carpata data no existe. Creando...")
            Files.createDirectory(dataPath)
            println("Carpeta data creada...")
        }
    }
}