package test

import solution.Solution355
import kotlin.test.Test
import kotlin.test.assertContentEquals

class Test355 : TestBase<Solution355.Twitter>(Solution355.Twitter()){
    @Test
    fun test() {
//        ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
//        [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//        Output
//        [null, null, [5], null, null, [6, 5], null, [5]]
        val t = solution
        t.postTweet(1, 5)
        assertContentEquals(listOf(5),  t.getNewsFeed(1))
        t.follow(1, 2)
        t.postTweet(2, 6)
        assertContentEquals(listOf(6,5), t.getNewsFeed(1))
        t.unfollow(1, 2)
        assertContentEquals(listOf(5), t.getNewsFeed(1))
    }
}