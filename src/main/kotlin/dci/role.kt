package dci

/**
 * 构建一个基础角色 Human
 */
open class HumanRole(p: IPerson) : IPerson by p {
    open fun eat(foodPrice: Int) {
        println("Human $identityCard is eating, cost $foodPrice yuan")
        bankCard.balance -= foodPrice
    }

    open fun sleep() = println("Human $identityCard is sleeping")
    open fun play() = println("Human $identityCard is playing")
}

/**
 * 一个Student, 必然是一个Human
 */
class StudentRole(p: IPerson) : HumanRole(p) {
    fun study() {
        println("Student $studentCard is studying")
    }

    fun exam() {
        println("Student $studentCard is examining")
    }
}

class WorkerRole(p: IPerson) : HumanRole(p) {
    fun work(salary: Int) {
        println("Worker $workerCard is working, salary is $salary")
    }

    fun offWork(salary: Int) {
        println("Worker $workerCard is off work, received $salary yuan ")
        bankCard.balance += salary
    }
}

class TouristRole(p: IPerson) : HumanRole(p) {
    fun buyTicket(fee: Int) {
        println("The tourist ${identityCard.name} spent $fee yuan on the tickets")
        bankCard.balance -= fee
    }

    fun visit() = println("Tourist ${identityCard.name} is enjoying")
}