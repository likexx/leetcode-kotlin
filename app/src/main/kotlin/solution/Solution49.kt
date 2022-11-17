package solution

import solution.annotation.Leetcode

class Solution49 {
    @Leetcode(49)
    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val buildKey = { s:String ->
                val letters = IntArray(26)
                s.forEach { letters[it-'a'] += 1 }

                letters.joinToString(".") { it.toString() }
            }

            val groups = hashMapOf<String, MutableList<String>>()
            for (s in strs) {
                val k = buildKey(s)
                println(k)
                if (!groups.containsKey(k)) {
                    groups[k] = mutableListOf<String>()
                }
                groups[k]!!.add(s)
            }

            return groups.values.toList()
        }
    }
}