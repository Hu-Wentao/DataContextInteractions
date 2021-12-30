package simple

/**
 * 训狗师 示例
 */

interface IAnimal {
    val name: String
}

class Animal(override val name: String) : IAnimal


open class HumanR(a: IAnimal) : IAnimal by a
open class DogRole(a: IAnimal) : IAnimal by a

class TrainerRole(a: IAnimal) : HumanR(a) {
    fun trainDog(a: DogRole): GuidDogRole {
        println("${a.name} is trained")
        return GuidDogRole(a)
    }
}

class GuidDogRole(a: IAnimal) : DogRole(a) {
    fun work(): String = "工作中..."
}

fun main() {

    var zs = HumanR(Animal("张三"))
    val ls = HumanR(Animal("李四"))
    var doge = DogRole(Animal("哈士奇"))

    zs = TrainerRole(zs) // 张三成为训狗师
    doge = zs.trainDog(doge) // 哈士奇被 张三(训狗师) 训练

    doge.work() // 导盲犬工作中...

    zs.trainDog(doge) // 哈士奇被 张三(训狗师) 再次训练,因为导盲犬和狗是继承关系
//    ls.trainDog(doge) // 哈士奇无法被 李四(人类) 训练,因为李四没有trainDog方法

//    zs.trainDog(ls) // 张三(训狗师)训不了李四(人类), 静态检查出错

}