package tidbits

open class Person {

}

class Employee : Person() {
    fun vacation(days: Int) {
        println("Yeah")
    }
}

class Contractor : Person()

fun hasVacations(person: Person) {
    if (person is Employee) {
        // Smart cast
        person.vacation(10)
    }
}

var input: Any = 10;
fun main() {
    // val str = input as String // ClassCastException
    val str = input as? String // safe cast or null
    println(str?.length)


}