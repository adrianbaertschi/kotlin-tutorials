// Name of the static class
@file:JvmName("MyUtil")

package interop

fun prefix(prefix: String, value: String): String {
    return "$prefix-$value"
}

val name = "Adrian"
const val constname = "Adrian"