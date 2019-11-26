package inheritance

import classes.Customer

interface Repository {
    val isEmpty: Boolean
        get() = true

    fun get(id: Int): Customer
    fun store(c: Customer) {
        // implementation in interface is possible
    }
}

class MyCustomerRepository : Repository {
    override fun get(id: Int): Customer {
        return Customer()
    }

    override fun store(c: Customer) {
        // custom implementation
    }
}


fun main() {
    val r = MyCustomerRepository()
    r.store(Customer())

    val c = C1()
    c.fA()
}