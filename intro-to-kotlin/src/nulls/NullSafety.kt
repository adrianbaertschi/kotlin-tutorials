package nulls

fun main() {
    //  val msg: String = null // does not compile
    val msg = "abc" // never null
    val nullMsg: String? = null // can be null

    println(msg.length)
    // println(nullMsg.length) // does not compile
    println(nullMsg?.length)
    println(nullMsg!!.length) // throws KotlinNullPointerException


}