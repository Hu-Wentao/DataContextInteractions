package dci

/**
 * 对象接口类, 确定对象拥有的字段
 */
interface IPerson {
    val identityCard: IdentityCard
    val bankCard: BankCard
    var studentCard: StudentCard?
    var workerCard: WorkerCard?
}

/**
 * Object的实现类, 直接对应数据库表, 甚至可以是Dto
 * 显然, 实现类与对象接口不一定是一对一的关系, 可以多个接口对应一个实现类
 */
class Person(
    override val identityCard: IdentityCard,
    override val bankCard: BankCard,
    override var studentCard: StudentCard?,
    override var workerCard: WorkerCard?
) : IPerson {
    companion object {
        fun of(
            identityCard: IdentityCard,
            bankCard: BankCard,
        ): Person = Person(identityCard, bankCard, null, null)
    }
}
