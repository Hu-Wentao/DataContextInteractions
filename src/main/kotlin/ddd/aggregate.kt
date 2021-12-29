package ddd

import kotlin.random.Random

class Home {
    lateinit var me: Person

    fun comeback(person: Person) {
        println("${person.identityCard} is coming back")
        me = person
    }

    // Home 的核心业务逻辑
    fun run() {
        me.eat()
        me.play()
        me.sleep()
    }
}

class School(
    val name: String,
    val students: MutableList<Person> = mutableListOf(),
) {
    fun receive(student: Person) {
        students.add(student.apply {
            this.studentCard = StudentCard("${Random.nextInt(100000, 999999)}", this.identityCard.name)
        })
        println("$name receive student ${student.studentCard}")
    }

    fun run() {
        println("$name start class")
        students.forEach { it.study() }

        println("$name start eating")
        students.forEach { it.eat() }

        println("$name start exercise")
        students.forEach { it.exam() }
    }
}

class Company(
    val name: String,
    val workers: MutableList<Person> = mutableListOf(),
) {
    fun employ(worker: Person) {
        workers.add(worker.apply {
            this.workCard = WorkCard("${Random.nextInt(100000, 999999)}", this.identityCard.name)
        })
        println("$name employ worker ${worker.workCard}")
    }

    fun run() {
        println("$name start working")
        workers.forEach { it.work() }

        println("$name start eating")
        workers.forEach { it.eat() }

        println("$name start exercise")
        workers.forEach { it.offWork() }
    }

}

class Park(
    val name: String,
    val tourists: MutableList<Person> = mutableListOf(),
) {
    fun welcome(tourist: Person) {
        tourists.add(tourist)
        println("$name welcome tourist ${tourist.identityCard}")
    }

    fun run() {
        println("$name start sell tickets")
        tourists.forEach { it.buyTicket() }

        println("$name start enjoy")
        tourists.forEach { it.enjoy() }

        println("finish enjoy")
    }
}