package simple

/**
 * 通过kotlin代理特性实现DCI
 */

/**
 * 1. Data 数据/领域对象
 * 相当于DDD建模中的贫血模型
 * 在本项目中, 通过(对象接口 + 实现类)利用kotlin代理特性以便Role进行代理
 */
interface IPerson {
    val name: String
    val height: Int
}

// 数据类, 可以是Dto, 类比贫血模型, 直接面向数据表
data class Person(
    override val name: String,
    override val height: Int,
) : IPerson

/**
 * 2. Role 角色
 * 用角色来分离Person在不同场景下的不同行为, 以便维护代码
 *
 * Human角色是可以被其他角色继承的
 */
open class HumanRole(p: IPerson) : IPerson by p {
    open fun role(): String = "高质量人类"
    open fun say(): String = "说点啥"
    open fun hello(): String = "我是${role()}, 我叫$name"
}

// 通过构造函数,传入 Person数据,
class StudentRole(p: IPerson) : HumanRole(p) {
    override fun role(): String = "学生"
    override fun say(): String = "老师好!"
    fun write(): String = "学生[$name] 写作业"
}

class TeacherRole(p: IPerson) : HumanRole(p) {
    override fun role(): String = "老师"
    override fun say(): String = "上课!"
    fun teach(): String = "bu la... bu la..."
}

/**
 * 3. Context 上下文(场景)
 * Role 与 Data之间的交互, 应当在 Context中进行
 * 用场景来限定Object的角色, 相同的Object在不同的Context(场景)下, 通过不同的Role(角色)有不同的行为
 */
class ClassRoom(
    var teacher: TeacherRole,
    var students: MutableList<StudentRole> = mutableListOf()
) {
    fun addStudent(student: StudentRole) {
        students.add(student)
        println("${student.name}加入了班级")
    }

    fun ring() {
        println("班级开始上课了=============")
        println(teacher.say())

        println("同学们好! ${teacher.hello()}")
        students.forEach { println("${it.say()} ${it.hello()}") }

        println(teacher.teach())
        students.forEach { println(it.write()) }
    }
}

fun main() {
    val p1 = Person("张三", 180)
    val p2 = Person("李四", 180)
    val p3 = Person("王五", 180)

    val teacher = TeacherRole(p1)
    val student1 = StudentRole(p2)
    val student2 = StudentRole(p3)

    val classRoom = ClassRoom(teacher)
    classRoom.addStudent(student1)
    classRoom.addStudent(student2)

    classRoom.ring()

    // 其他
    println("花絮 ====================")
    val human = HumanRole(teacher)
    println("大家好 ${human.hello()}")
}