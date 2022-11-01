package jar

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


fun main(args: Array<String>) {

    when (args.size) {
        1 -> {
            val url = URL(args[0])
            BufferedReader(InputStreamReader(url.openStream())).use { br ->
                var line: String?
                val sb = StringBuilder()
                while (br.readLine().also { line = it } != null) {
                    sb.append(line)
                    sb.append(System.lineSeparator())
                }
                println(sb)
            }
        }

        else -> println("Invalid arguments")
    }
}

/*

// Esta es otra forma de leer una pagina usando URL

val url = URL("https://www.google.es/")
val urlConnection = url.openConnection() as HttpURLConnection

try {
    val text = urlConnection.inputStream.bufferedReader().readText()
    println(text)
} finally {
    urlConnection.disconnect()
}
*/
