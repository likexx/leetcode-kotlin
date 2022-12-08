package solution

import solution.annotation.Leetcode

class Solution355 {
    @Leetcode(355)
    class Twitter() {
        val tweets = hashMapOf<Int, List<Pair<Int, Long>>>()
        val follows = hashMapOf<Int, Set<Int>>()
        var sequence = 0L

        fun postTweet(userId: Int, tweetId: Int) {
            val userTweets = tweets.getOrDefault(userId, mutableListOf<Pair<Int, Long>>()).toMutableList()
            sequence += 1
            userTweets.add(Pair(tweetId, sequence))
            tweets[userId] = userTweets.toList()
        }

        fun getNewsFeed(userId: Int): List<Int> {
            val feeds = mutableListOf<Pair<Int, Long>>()

            val userFeeds = tweets.getOrDefault(userId, mutableListOf())
            for (i in userFeeds.size - 1 downTo kotlin.math.max(0, userFeeds.size - 10)) {
                feeds.add(userFeeds[i])
            }

            val userFollows = follows.getOrDefault(userId, setOf<Int>())
            userFollows.forEach {
                val followFeeds = tweets.getOrDefault(it, listOf())
                for (i in followFeeds.size-1 downTo kotlin.math.max(0, followFeeds.size - 10)) {
                    feeds.add(followFeeds[i])
                }
            }

            feeds.sortByDescending { it.second }
            val sorted = feeds.map { it.first }
            return sorted.slice(0..kotlin.math.min(9, sorted.size - 1))
        }

        fun follow(followerId: Int, followeeId: Int) {
            val userFollows = follows.getOrDefault(followerId, hashSetOf<Int>()).toMutableSet()
            userFollows.add(followeeId)
            follows[followerId] = userFollows
        }

        fun unfollow(followerId: Int, followeeId: Int) {
            val userFollows = follows.getOrDefault(followerId, hashSetOf<Int>()).toMutableSet()
            userFollows.remove(followeeId)
            follows[followerId] = userFollows
        }

    }
}