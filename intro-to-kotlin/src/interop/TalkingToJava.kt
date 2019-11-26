package interop

fun main() {
    val customerJava = CustomerJava()
    customerJava.name = "Adrian" // no setter needed
    val name = customerJava.name // not getter needed

    customerJava.prettyPrint()

    val neverNull = customerJava.neverNull();
    val maybeNull = customerJava.maybeNull()

    val runnable = Runnable { println("runIt") }
    runnable.run()
}

class PersonKotlin : PersonJava() {

}