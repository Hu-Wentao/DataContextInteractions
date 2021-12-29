package simple

/**
 * 通过kotlin代理特性实现DCI
 */
interface IPerson {
    val name: String
    val height: Int
    fun role(): String
    fun say(): String
    fun hello(): String = "hello! 我叫$name，我是${role()}"
}

data class Person(
    override val name: String,
    override val height: Int,
) : IPerson {
    override fun role(): String = "高质量人类"
    override fun say(): String = "说点啥"
}


class Student(p: IPerson) : IPerson by p {
    override fun role(): String = "学生"
    override fun say(): String = "老师好!"
    fun write(): String = "学生写字"
}

class Teacher(p: IPerson) : IPerson by p {
    override fun role(): String = "老师"
    override fun say(): String = "上课!"
    override fun hello(): String = "hello! 我叫$name，我是${role()}"
    fun teach(): String = "bu la... bu la..."
}


fun main() {
    fun stuTest(s: Student) {
        println(s.hello()) // 没有覆写 。。。
        println(s.say())
        println(s.write())
    }

    fun teachTest(t: Teacher) {
        println(t.hello())
        println(t.say())
        println(t.teach())
    }

    Person(
        "张三",
        200,
    ).let {
        stuTest(Student(it))
        teachTest(Teacher(it))
    }
}