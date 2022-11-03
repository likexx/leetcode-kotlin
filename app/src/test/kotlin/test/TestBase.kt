package test

import org.junit.Before
import test.annotation.Leetcode
import test.annotation.LeetcodeMetaConfig
import kotlin.reflect.KClass

abstract class TestBase<T: Any>(val solution: T)  {
    @Before
    fun setup() {
        displayAnnotation(solution::class.java.kotlin as KClass<T>)
    }

    fun displayAnnotation(c: KClass<T>) {
        val lc = c.annotations.find { it is Leetcode } as? Leetcode?
        val metaData = LeetcodeMetaConfig.getMetaFromID(lc!!.id)
        print("${metaData.link} [${metaData.level}]")
    }
}