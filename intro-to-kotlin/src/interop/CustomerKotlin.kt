package interop

import java.io.IOException

class CustomerKotlin(var id: Int, var name: String) {

    @JvmField
    val someField = "Value"

    @JvmOverloads
    fun changeStatus(status: String = "Open") {
    }

    @JvmName("pref") // Name for Kotlin code
    fun makePreferred() {
    }

    @Throws(IOException::class)
    fun loadStats(filename: String) {
        if (filename.isBlank()) {
            throw IOException("Filename is blank")
        }
    }
}

fun CustomerKotlin.extension() {

}