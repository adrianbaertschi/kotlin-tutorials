package inheritance

import classes.Customer

/**
 * Interace vs. Abstract class
 * interface cannot have state
 * Multiple inheritance is nos possible with abstract class
 */


interface Repo {
    val isEmpty: Boolean
        get() = true

    fun get(id: Int): Customer
    fun store(c: Customer) {
        // implementation in interface is possible
    }
}

class MyCustomerRepo : Repo {
    override fun get(id: Int): Customer {
        return Customer()
    }

    override fun store(c: Customer) {
        // custom implementation
    }
}

interface Int1 {
    fun fA() {
        println("A from Int1")
    }
}

interface Int2 {
    fun fA() {
        println("A from Int2")
    }
}

class C1 : Int1, Int2 {
    override fun fA() {
        super<Int1>.fA(); // Specify which parent in <>
    }

}

fun main() {
    val r = MyCustomerRepo()
    r.store(Customer())

    val c = C1()
    c.fA()
}