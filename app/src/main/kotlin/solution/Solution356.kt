package solution

import solution.annotation.Leetcode
import kotlin.math.max

class Solution356 {
    @Leetcode(356)
    class Solution {
        fun isReflected(points: Array<IntArray>): Boolean {
            val distincts = mutableSetOf<Pair<Int, Int>>()
            points.forEach { distincts.add(Pair(it[0], it[1])) }

            var minX = Int.MAX_VALUE
            var maxX = Int.MIN_VALUE
            for (p in distincts) {
                minX = kotlin.math.min(minX, p.first)
                maxX = kotlin.math.max(maxX, p.first)
            }
            val mid = (minX + maxX)/2.0

            for (p in distincts) {
                val expect = Pair((mid + mid - p.first).toInt(), p.second)
                if (!distincts.contains(expect)) {
                    return false
                }
            }

            return true
        }

        fun isReflected_WithSort(points: Array<IntArray>): Boolean {
            val distincts = mutableSetOf<Pair<Int, Int>>()
            points.forEach { distincts.add(Pair(it[0], it[1])) }
            val distinctPoints = distincts.toMutableList()

            val map = hashMapOf<Int, MutableList<Int>>()
            var minX = Int.MAX_VALUE
            var maxX = Int.MIN_VALUE
            for (p in distinctPoints) {
                minX = kotlin.math.min(minX, p.first)
                maxX = kotlin.math.max(maxX, p.first)

                val pys = map.getOrDefault(p.first, mutableListOf())
                pys.add(p.second)
                map[p.first] = pys
            }

            for (k in map.keys) {
                map[k] = map[k]!!.sorted().toMutableList()
            }

            val mid = (minX + maxX)/2.0
            val pxes = map.keys.toMutableList().sorted()

            for (x1 in pxes) {
                val x2 = (mid + (mid - x1)).toInt()
                if (x2==x1) {
                    break
                }
                if (!map.containsKey(x2)) {
                    return false
                }
                if (map[x1]!! != map[x2]!!) {
                    return false
                }
            }

            return true
        }
    }
}