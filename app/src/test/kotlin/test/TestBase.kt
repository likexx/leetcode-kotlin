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

    inline fun <reified T> convertToArray(s: String): Array<T> {
        var ss = s.removePrefix("[").removeSuffix("]")
        var values = ss.split(",").filter { it.isNotEmpty() }
        val result = mutableListOf<T>()
        for (v in values) {
            var data: T
            when (T::class) {
                Int::class -> data = v.toInt() as T
                Float::class -> data = v.toFloat() as T
                Double::class -> data = v.toDouble() as T
                String::class -> data = v as T
                else -> data = v as T
            }

            result.add(data)
        }

        return result.toTypedArray()
    }
}