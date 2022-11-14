package solution

import solution.annotation.Leetcode

class Solution947 {
    @Leetcode(947)
    class Solution {
        fun removeStones(stones: Array<IntArray>): Int {
            // union find. remove all connected components
            val N = stones.size
            val parents = IntArray(N) { -1 }
            val sizes = IntArray(N)  { 1 }

            fun getParent(i: Int): Int {
                if (parents[i]==-1) {
                    return i
                }
                val p = getParent(parents[i])
                parents[i]=p
                return p
            }

            fun union(i: Int, j: Int) {
                val p1 = getParent(i)
                val p2 = getParent(j)
                if (p1==p2) {
                    return
                }
                val s1=sizes[p1]
                val s2=sizes[p2]
                if (s1>=s2) {
                    parents[p2]=p1
                    sizes[p1]+=sizes[p2]
                } else {
                    parents[p1]=p2
                    sizes[p2]+=sizes[p1]
                }
            }

            for (i in stones.indices) {
                for (j in 0..i-1) {
                    if (stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) {
                        union(i, j)
                    }
                }
            }

            val groups = hashSetOf<Int>()
            for (i in stones.indices) {
                groups.add(getParent(i))
            }

            return stones.size - groups.size
        }

        fun removeStonesDFS(stones: Array<IntArray>): Int {
            val rows = hashMapOf<Int, HashSet<Int>>()
            val cols = hashMapOf<Int, HashSet<Int>>()

            for ((i,s) in stones.withIndex()) {
                val y = s[0]
                val x = s[1]

                val v1 = rows.getOrDefault(y, hashSetOf())
                v1.add(i)
                rows[y]=v1

                val v2 = cols.getOrDefault(x, hashSetOf())
                v2.add(i)
                cols[x]=v2
            }

            val visited = hashSetOf<Int>()
            fun dfs(i: Int) {
                if (visited.contains(i)) {
                    return
                }
                visited.add(i)
                for (j in rows[stones[i][0]]!!) {
                    dfs(j)
                }
                for (j in cols[stones[i][1]]!!) {
                    dfs(j)
                }
            }

            var count=0
            for (i in stones.indices) {
                if (!visited.contains(i)) {
                    count+=1
                    dfs(i)
                }
            }

            return stones.size - count
        }

        fun removeStonesNaive(stones: Array<IntArray>): Int {
            val adjs = hashMapOf<Int, HashSet<Int>>()

            for (i in 0..stones.size-1) {
                adjs[i] = adjs.getOrDefault(i, hashSetOf())
                for (j in i+1..stones.size-1) {
                    if (stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) {
                        val v1 = adjs.getOrDefault(i, hashSetOf())
                        v1.add(j)
                        adjs[i]=v1

                        val v2 = adjs.getOrDefault(j, hashSetOf())
                        v2.add(i)
                        adjs[j]=v2
                    }
                }
            }

            val visited = hashSetOf<Int>()

            fun dfs(i: Int) {
                if (visited.contains(i)) {
                    return
                }
                visited.add(i)
                for (j in adjs[i]!!) {
                    dfs(j)
                }
            }

            var count=0
            for (i in stones.indices) {
                if (!visited.contains(i)) {
                    count+=1
                    dfs(i)
                }
            }

            return stones.size - count
        }
    }
}