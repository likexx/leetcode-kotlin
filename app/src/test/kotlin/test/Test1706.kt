package test

import org.junit.Before
import kotlin.test.Test
import kotlin.test.*

class Test1706 : TestBase<Solution1706.Solution>(Solution1706.Solution()) {
    @Test
    fun test() {
        val s = Solution1706.Solution()
        val tests = listOf(
            Pair(intArrayOf(1,-1,-1,-1,-1),
                arrayOf(intArrayOf(1,1,1,-1,-1),
                        intArrayOf(1,1,1,-1,-1),
                        intArrayOf(-1,-1,-1,1,1),
                        intArrayOf(1,1,1,1,-1),
                        intArrayOf(-1,-1,-1,-1,-1))),

            Pair(intArrayOf(-1), arrayOf(intArrayOf(-1))),

            Pair(intArrayOf(0,1,2,3,4,-1),
                arrayOf(intArrayOf(1,1,1,1,1,1),
                    intArrayOf(-1,-1,-1,-1,-1,-1),
                    intArrayOf(1,1,1,1,1,1),
                    intArrayOf(-1,-1,-1,-1,-1,-1)
                )
            )
        )
        tests.forEach {
            val res=s.findBall((it.second))
            assertContentEquals(it.first,res)
        }

        tests.forEach {
            val res=s.findBallDP((it.second))
            assertContentEquals(it.first,res)
        }

    }

}
