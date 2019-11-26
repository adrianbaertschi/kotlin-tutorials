package classes

import java.time.LocalDate

// Only properties, no fields
class Customer(var name: String = "", var email: String = "", val yearOfBirth: Int = 1990) {

    // custom getter
    val age: Int
        get() = LocalDate.now().year - yearOfBirth

    // custom setter, assign via field = ...
    var ssn: String = ""
        set(myValue) {
            if (!myValue.startsWith("SN")) {
                return
            }
            field = myValue;
        }
}

// equals, hashCode, toString provided
data class Customer2(var id: Int, var name: String)

fun main() {
    val c = Customer("Max", yearOfBirth = 1990);
    c.ssn = "SNasdf"
    println(c.name)
    println(c.age)
    println(c.ssn)

    val c2 = Customer2(1, "Adrian")
    val c3 = Customer2(1, "Adrian")
    println(c2)

    println(c2 == c3)

    val c4 = c3.copy(id = 4)
    println(c4)

}