package solution

import solution.annotation.Leetcode

class Solution1657 {
    @Leetcode(1657)
    class Solution {
        fun closeStrings(word1: String, word2: String): Boolean {
            // instead of using hash map which could be O(n) space for frequency, use fixed size array and bit value for O(1) space
            var bits1: Int = 0
            var bits2: Int = 0
            val arr1 = IntArray(26)
            val arr2 = IntArray(26)

            word1.forEach {
                val offset = it - 'a'
                arr1[offset]+=1
                bits1 = bits1 or (1 shl offset)
            }

            word2.forEach {
                val offset = it - 'a'
                arr2[offset]+=1
                bits2 = bits2 or (1 shl offset)
            }

            if (bits1 != bits2) {
                return false
            }

            return arr1.sorted() == arr2.sorted()
        }

        fun closeStrings_Simple(word1: String, word2: String): Boolean {
            val map1 = hashMapOf<Char, Int>()
            word1.forEach { map1[it] = map1.getOrDefault(it, 0) + 1 }
            val map2 = hashMapOf<Char, Int>()
            word2.forEach { map2[it] = map2.getOrDefault(it, 0) + 1 }

            var matchedKeys = 0
            for (k in map1.keys) {
                if (map2.containsKey(k)) {
                    matchedKeys += 1
                }
            }
            if (matchedKeys != map1.keys.size || map1.keys.size != map2.keys.size) {
                return false
            }

            val count1 = hashMapOf<Int, Int>()
            val count2 = hashMapOf<Int, Int>()

            for (k in map1.keys) {
                val c = map1[k]!!
                count1[c] = count1.getOrDefault(c, 0) + 1
            }

            for (k in map2.keys) {
                val c = map2[k]!!
                count2[c] = count2.getOrDefault(c, 0) + 1
            }

            for (k in count1.keys) {
                if (count1.getOrDefault(k, 0) != count2.getOrDefault(k, 0)) {
                    return false
                }
                count2.remove(k)
            }

            return count2.isEmpty()
        }
    }
}