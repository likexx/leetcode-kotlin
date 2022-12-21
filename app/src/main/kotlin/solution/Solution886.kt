package solution

import solution.annotation.Leetcode

class Solution886 {
    @Leetcode(886)
    class Solution {
        fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
            val map = hashMapOf<Int, MutableSet<Int>>()
            for (d in dislikes) {
                var v = map.getOrDefault(d[0], mutableSetOf())
                v.add(d[1])
                map[d[0]]=v
                v = map.getOrDefault(d[1], mutableSetOf())
                v.add(d[0])
                map[d[1]]=v
            }

            val colors = IntArray(n+1) { -1 }

            fun color(i: Int, v: Int): Boolean {
                if (colors[i]==v) {
                    return true
                }
                if (colors[i]!=-1 && colors[i]!=v) {
                    return false
                }
                colors[i]=v
                val others = map.getOrDefault(i, mutableSetOf())
                for (o in others) {
                    if (!color(o, 1-v)) {
                        colors[i]=-1
                        return false
                    }
                }
                return true
            }

            for (i in 1..n) {
                if (colors[i]==-1 && !color(i, 0) && !color(i, 1)) {
                    return false
                }
            }
            return true
        }
    }
}