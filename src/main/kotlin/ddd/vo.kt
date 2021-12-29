package ddd

data class IdentityCard(
    val id: String,
    val name: String,
)

data class StudentCard(
    val id: String,
    val name: String,
)

data class WorkCard(
    val id: String,
    val name: String,
)

data class BankCard(
    val id: String,
    var balance: Int,
)