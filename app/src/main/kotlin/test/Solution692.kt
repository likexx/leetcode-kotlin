package test

import java.util.PriorityQueue

class Solution692 {
    class Solution {
        fun topKFrequent(words: Array<String>, k: Int): List<String> {
            val result= mutableListOf<String>()
            val q=PriorityQueue<Pair<String, Int>>(k, Comparator {p1, p2 ->
                if (p1.second != p2.second) {
                    return@Comparator p1.second.compareTo(p2.second)
                }
                return@Comparator -p1.first.compareTo(p2.first)
            })
            var freqs = words.groupingBy { it }.eachCount()

            for (key in freqs.keys) {
                q.add(Pair(key, freqs[key]!!))
                if (q.size > k) {
                    q.poll()
                }
            }

            while (q.size > 0) {
                result.add(q.poll().first)
            }

            return result.reversed()
        }
    }
}