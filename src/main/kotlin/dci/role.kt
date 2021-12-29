package dci

/**
 * 构建一个基础角色 Human
 */
open class HumanRole(p: IPerson) : IPerson by p {
    open fun eat() {
        println("Human $identityCard is eating")
        bankCard.balance--
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
    fun work() {
        println("Worker $workerCard is working")
        bankCard.balance++
    }

    fun offWork() = println("Worker $workerCard is off work")
}

class TouristRole(p: IPerson) : HumanRole(p) {
    fun buyTicket() {
        println("Tourist is buying ticket")
        bankCard.balance--
    }

    fun enjoy() = println("Tourist  is enjoying")
}