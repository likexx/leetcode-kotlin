package test

import test.annotation.Leetcode

class Solution433 {
    @Leetcode(433)
    class Solution {
        fun minMutation(start: String, end: String, bank: Array<String>): Int {
            fun isNeighbor(s1:String, s2:String): Boolean {
                var count=0
                for (i in 0..s1.length-1) {
                    if (s1[i]!=s2[i]) {
                        count+=1
                    }
                    if (count>1) {
                        return false
                    }
                }
                return count==1
            }
            val neighbors = hashMapOf<String, MutableSet<String>>()
            for (s1 in bank) {
                if (!neighbors.containsKey(s1)) {
                    neighbors[s1]= mutableSetOf()
                }
                for (s2 in bank) {
                    if (s1==s2) {
                        continue
                    }
                    if (isNeighbor(s1, s2)) {
                        if (!neighbors.containsKey(s1)) {
                            neighbors[s1]= mutableSetOf()
                        }
                        neighbors[s1]?.add(s2)
                        if (!neighbors.containsKey(s2)) {
                            neighbors[s2]= mutableSetOf()
                        }
                        neighbors[s2]?.add(s1)
                    }
                }
            }

            val visited = mutableSetOf<String>()

            val q= mutableListOf<Pair<String,Int>>()
            for (s in neighbors.keys) {
                if (isNeighbor(start, s)) {
                    q.add(Pair(s, 1))
                    visited.add(s)
                }
            }

            while (q.size>0) {
                val (s, steps)=q[0]
                q.removeAt(0)
                if (s==end) {
                    return steps
                }

                for (next in neighbors[s]!!) {
                    if (visited.contains(next)) {
                        continue
                    }
                    q.add(Pair(next, steps+1))
                    visited.add(s)
                }
            }
            return -1
        }
    }
}