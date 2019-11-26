package inheritance

import classes.Customer

interface RepoIntf<T> {
    fun getByIid(id: Int): T
    fun getAll(): List<T>
}

fun main() {

    val cr = GenericRepo<Customer>()

}