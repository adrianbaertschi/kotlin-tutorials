package ch.adba.springdemoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.domain.AbstractPersistable
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.persistence.Entity

@SpringBootApplication
class SpringDemoAppApplication

fun main(args: Array<String>) {
    runApplication<SpringDemoAppApplication>(*args)
}

@RestController
class MyController(var repo: GreetingRepository) {
    @GetMapping("greeting")
    fun greet(): String {
        val greeting = Greeting("Hello " + UUID.randomUUID())
        repo.save(greeting)
        return greeting.word
    }

    @GetMapping("greeting/all")
    fun getAll(): List<Greeting> = repo.findAll().toList()
}

@Entity
data class Greeting(val word: String) : AbstractPersistable<Long>()

interface GreetingRepository : CrudRepository<Greeting, Long>
