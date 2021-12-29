package ddd

import kotlin.random.Random

class Person(name: String) {
    var identityCard: IdentityCard = IdentityCard("${Random.nextInt(100, 999)}", name)
    lateinit var workCard: WorkCard
    lateinit var studentCard: StudentCard
    var bankCard: BankCard = BankCard("${Random.nextInt(100, 999)}", Random.nextInt(100, 999))

    fun study() {
        println("student $studentCard studying")
    }

    fun exam() {
        println("student $studentCard examining")
    }

    fun eat() {
        println("people $identityCard eating")
        this.bankCard.balance--
    }

    fun play() {
        println("people $identityCard playing")
    }

    fun work() {
        println("Worker $workCard working")
        this.bankCard.balance++
    }

    fun offWork() {
        println("Worker $workCard offWork")
    }

    fun buyTicket() {
        println("People $identityCard buying ticket")
        this.bankCard.balance--
    }

    fun enjoy() {
        println("People $identityCard enjoying")
    }

    fun sleep() {
        println("People $identityCard sleeping")

    }
}