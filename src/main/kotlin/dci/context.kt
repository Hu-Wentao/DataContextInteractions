package dci

import ddd.Person
import ddd.WorkCard
import kotlin.random.Random

class Home {
    lateinit var me: HumanRole

    fun backHome(man: HumanRole) {
        me = man
        println("${me.identityCard} is back Home")
    }

    fun run() {
        me.eat()
        me.play()
        me.sleep()
    }
}

class School(
    val name: String,
    val students: MutableList<StudentRole> = mutableListOf(),
) {
    fun receive(stu: StudentRole) {
        students.add(stu.apply {
            this.studentCard = StudentCard("${Random.nextInt(100000, 999999)}", this.identityCard.name)
        })
        println("$name receive student ${stu.studentCard}")
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
    val workers: MutableList<WorkerRole> = mutableListOf(),
) {
    fun employ(worker: WorkerRole) {
        workers.add(worker.apply {
            this.workerCard = WorkerCard("${Random.nextInt(100000, 999999)}", this.identityCard.name)
        })
        println("$name employ worker ${worker.workerCard}")
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
    val tourists: MutableList<TouristRole> = mutableListOf(),
) {
    fun welcome(tourist: TouristRole) {
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