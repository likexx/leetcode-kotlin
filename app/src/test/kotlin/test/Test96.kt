package test

import solution.Solution96
import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test96 : TestBase<Solution96.Solution> (Solution96.Solution()) {
    @Test
    fun test() {
        assertContentEquals(listOf("255.255.11.135","255.255.111.35"), solution.restoreIpAddresses("25525511135"))
        assertContentEquals(listOf("0.0.0.0"), solution.restoreIpAddresses("0000"))
        assertContentEquals(listOf("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"), solution.restoreIpAddresses("101023"))
    }
}