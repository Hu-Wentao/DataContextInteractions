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
        val alice = Person.of(
            IdentityCard("${Random.nextInt(100, 999)}", "alice"),
            BankCard("${Random.nextInt(100, 999)}", Random.nextInt(100)),
        )

        println("===== 上学 =====")
        val hfuu = School("HFUU")
        hfuu.receive(StudentRole(bob)) // 切换到学生角色
        hfuu.run()

        // 工作
        println("===== 工作 =====")
        val sc = Company("ShuttleCloud")
        // 切换到员工角色
        val wkBob = WorkerRole(bob)
        val wkAlic = WorkerRole(alice)
        sc.employ(wkBob)
        sc.employ(wkAlic)
        sc.run()
        // 游玩
        println("===== 游玩 =====")
        // 切换到游客角色
        val tourBob = TouristRole(bob)
        val tourAlic = TouristRole(alice)

        val park = Park("Nanyan Lake")
        park.welcome(tourBob)
        park.welcome(tourAlic)
        park.run()

        // 回家
        println("===== 回家 =====")
        val home = Home() // 切换到人类角色
        val humBob = HumanRole(bob)
        val humAlice = HumanRole(alice)
        home.backHome(humBob)
        home.run()
        home.backHome(humAlice)
        home.run()
    }
}