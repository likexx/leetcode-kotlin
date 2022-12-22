package test

import org.junit.Before
import solution.annotation.Leetcode
import solution.annotation.LeetcodeMetaConfig
import kotlin.reflect.KClass

abstract class TestBase<T: Any>(val solution: T)  {
    @Before
    fun setup() {
        displayAnnotation(solution::class.java.kotlin as KClass<T>)
    }

    fun displayAnnotation(c: KClass<T>) {
        val lc = c.annotations.find { it is Leetcode } as? Leetcode?
        val metaData = LeetcodeMetaConfig.getMetaFromID(lc!!.id)
        println("${metaData.link} [${metaData.level}]")
    }

    inline fun convertToIntArray(s: String): IntArray {
        var ss = s.removePrefix("[").removeSuffix("]")
        var values = ss.split(",").filter { it.isNotEmpty() }
        val result = mutableListOf<Int>()
        for (v in values) {
            result.add(v.toInt())
        }
        return result.toIntArray()
    }
}