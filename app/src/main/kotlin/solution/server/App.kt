package solution.server

import com.sun.net.httpserver.HttpServer
import java.io.File
import java.net.InetSocketAddress
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists

fun main() {
    val baseDir = Paths.get(Paths.get("").toAbsolutePath().toString(), "..", "docs").toString()
    val server = HttpServer.create(InetSocketAddress(8080), 0)

    server.createContext("/") {
        val uri = it.requestURI
        val name = File(uri.path).absolutePath
        val filepath = File(baseDir, name)

        val h = it.responseHeaders
        h.add("Content-Type", "text/html")
        var resp = it.responseBody

        if (!filepath.exists()) {
            println("file not found: $filepath")
            it.sendResponseHeaders(404, 0)
            resp.write("404 not found on local server".toByteArray())
        } else {
            it.sendResponseHeaders(200, filepath.length())
            resp.write(Files.readAllBytes(filepath.toPath()))
        }

        resp.close()
    }

    server.start()
    println("server started")
}
