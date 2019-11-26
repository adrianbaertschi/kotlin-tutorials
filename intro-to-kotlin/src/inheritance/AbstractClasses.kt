package inheritance

abstract class Entity {
    var active = true;
    abstract fun init()
}

class MyImpl : Entity() {
    override fun init() {
        active = false
    }
}

fun main() {
    val e = MyImpl();
    e.init()
    println(e.active)
}