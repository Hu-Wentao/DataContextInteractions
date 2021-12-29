package dci

import kotlin.random.Random

class Home {
    lateinit var me: HumanRole

    fun backHome(man: HumanRole) {
        me = man
        println("${me.identityCard} is back Home")
    }

    fun run() {
        me.eat(0)
        me.play()
        me.sleep()
    }
}

class School(
    val name: String,
    val foodPrice: Int = 10,
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
        students.forEach { it.eat(foodPrice) }

        println("$name start exercise")
        students.forEach { it.exam() }
    }
}

class Company(
    val name: String,
    val salary: Int = 200,
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
        workers.forEach { it.work(salary) }

        println("$name start eating")
        workers.forEach { it.eat(0) }

        println("$name off work")
        workers.forEach { it.offWork(salary) }
    }

}

class Park(
    val name: String,
    val fee: Int = 10,
    val tourists: MutableList<TouristRole> = mutableListOf(),
) {
    fun welcome(tourist: TouristRole) {
        tourists.add(tourist)
        println("$name welcome tourist ${tourist.identityCard}")
    }

    fun run() {
        println("$name start sell tickets($fee yuan)")
        tourists.forEach { it.buyTicket(fee) }

        println("$name start visit")
        tourists.forEach { it.visit() }

        println("The $name park is closed")
    }
}