package ddd

import org.junit.jupiter.api.Test

internal class AggregateTest{
    @Test
    fun test(){
        val bob = Person("Bob")

        val hfuu = School("HFUU")
        val sc = Company("ShuttleCloud")
        val home = Home()
        val park = Park("Nanyan Lake")
        // 上学
        hfuu.receive(bob)
        hfuu.run()
        // 回家
        home.comeback(bob)
        home.run()
        // 工作
        sc.employ(bob)
        sc.run()
        // 游玩
        park.welcome(bob)
        park.run()
    }
}