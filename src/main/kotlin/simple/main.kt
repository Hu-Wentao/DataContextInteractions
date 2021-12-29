package simple

/**
 * 通过kotlin代理特性实现DCI
 */

/**
 * 对象的接口, 以便Role进行代理
 */
interface IPerson {
    val name: String
    val height: Int
}

/**
 * 数据类, 相当于贫血模型, 直接面向数据表
 */
data class Person(
    override val name: String,
    override val height: Int,
) : IPerson

/**
 * Human角色是可以被其他角色继承的
 */
open class HumanRole(p: IPerson) : IPerson by p {
    open fun role(): String = "高质量人类"
    open fun say(): String = "说点啥"
    open fun hello(): String = "hello! 我叫$name，我是${role()}"
}

/**
 * 通过构造函数,传入 Person数据,
 */
class StudentRole(p: IPerson) : HumanRole(p) {
    override fun role(): String = "学生"
    override fun say(): String = "老师好!"
    fun write(): String = "学生写字"
}

class TeacherRole(p: IPerson) : HumanRole(p) {
    override fun role(): String = "老师"
    override fun say(): String = "上课!"
    override fun hello(): String = "hello! 我叫$name，我是${role()}"
    fun teach(): String = "bu la... bu la..."
}


fun main() {
    fun humanTest(s: HumanRole) {
        println("===================")
        println(s.hello())
        println(s.say())
    }

    fun stuTest(s: StudentRole) {
        println("===================")
        println(s.hello()) // 没有覆写 。。。
        println(s.say())
        println(s.write())
    }

    fun teachTest(t: TeacherRole) {
        println("===================")
        println(t.hello())
        println(t.say())
        println(t.teach())
    }

    Person(
        "张三",
        200,
    ).let {
        // 使用构造函数, 切换角色
        humanTest(HumanRole(it))
        stuTest(StudentRole(it))
        teachTest(TeacherRole(it))
    }
}