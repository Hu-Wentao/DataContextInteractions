package dci

/**
 * 相当于 VO
 */

data class IdentityCard(
    val id: String,
    val name: String,
)

data class StudentCard(
    val id: String,
    val name: String,
)

data class WorkerCard(
    val id: String,
    val name: String,
)

data class BankCard(
    val id: String,
    var balance: Int,
)
