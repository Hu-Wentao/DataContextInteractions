package dci

import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class Test {
    @Test
    fun test() {
        val bob = Person.of(
            IdentityCard("${Random.nextInt(100, 999)}", "bob"),
            BankCard("${Random.nextInt(100, 999)}", Random.nextInt(100)),
        )


        println("===== 上学 =====")
        val hfuu = School("HFUU")
        hfuu.receive(StudentRole(bob)) // 切换到学生角色
        hfuu.run()
        // 回家
        println("===== 回家 =====")
        val home = Home() // 切换到人类角色
        home.backHome(HumanRole(bob))
        home.run()
        // 工作
        println("===== 工作 =====")
        val sc = Company("ShuttleCloud")
        sc.employ(WorkerRole(bob)) // 切换到员工角色
        sc.run()
        // 游玩
        println("===== 游玩 =====")
        val park = Park("Nanyan Lake")
        park.welcome(TouristRole(bob)) // 切换到游客角色
        park.run()
    }
}