package stdlib

import interop.CustomerKotlin

fun main() {

    // https://kotlinlang.org/docs/reference/scope-functions.html

    // common code
    val customer = CustomerKotlin(1, "Adrian");
    customer.name = "New name"
    customer.changeStatus("Bla")
    println(customer)

    // let (uses it, returns lambda result)
    val resultLet = customer.let {
        it.name = "New name"
        it.changeStatus("Bla")
        println(it)
        "result"
    }

    // also (uses it, returns context object)
    val resultAlso = customer.also {
        it.name = "New name"
        it.changeStatus("asdf")
        println(it)
    }

    // apply (uses this, returns context object)
    val applied = customer.apply {
        name = "New Name"
        changeStatus("Bla")
        println(this)
    }

    // run (uses this, returns lambda result)
    val resultRun = customer.run {
        name = "New name"
        changeStatus("asdf")
        println(this)
        "asdf"
    }

    // with (uses this, return lambda result)
    val resultWith = with(customer) {
        name = "New name"
        changeStatus("vla")
        println(this)
        "result" // is returned
    }

}