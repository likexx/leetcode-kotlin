package solution

import solution.annotation.Leetcode

class Solution834 {
    @Leetcode(834)
    class Solution {
        fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
            // we could come up with 2 formulas:
            // 1. if j is the neighbor of i, distances[i] += distances[j] + # of nodes in node j, and iterate for each j
            // 2. if there is edge (i,j), for subtree i and subtree j, we have:
            // distances[i] - distances[j] = (N - count[i]) - count[i] =>
            // distances[i] = distances[j] + (N-2*count[i])
            val neighbors = hashMapOf<Int, MutableSet<Int>>()
            for (e in edges) {
                var vertices = neighbors.getOrDefault(e[0], mutableSetOf())
                vertices.add(e[1])
                neighbors[e[0]] = vertices

                vertices = neighbors.getOrDefault(e[1], mutableSetOf())
                vertices.add(e[0])
                neighbors[e[1]] = vertices
            }

            // total nodes in subtree of i
            val count = IntArray(n) { 1 }

            val distances = IntArray(n) { 0 }

            // find the result for distance[0], and update count[i]
            fun countForRoot(i: Int, parent: Int) {
                val vertices = neighbors.getOrDefault(i, mutableSetOf())
                for (j in vertices) {
                    if (j == parent) {
                        continue
                    }
                    countForRoot(j, i)
                    count[i] += count[j]
                    distances[i] += distances[j] + count[j]
                }
            }

            // update for each node
            fun updateForEachNode(i: Int, parent: Int) {
                val vertices = neighbors.getOrDefault(i, mutableSetOf())
                for (j in vertices) {
                    if (j==parent) {
                        continue
                    }
                    distances[j] = distances[i] + n - 2 * count[j]
                    updateForEachNode(j, i)
                }
            }

            countForRoot(0, -1)
            updateForEachNode(0, -1)
            return distances
        }

        fun sumOfDistancesInTree_Naive(n: Int, edges: Array<IntArray>): IntArray {
            val neighbors = hashMapOf<Int, MutableSet<Int>>()
            for (e in edges) {
                var vertices = neighbors.getOrDefault(e[0], mutableSetOf())
                vertices.add(e[1])
                neighbors[e[0]] = vertices

                vertices = neighbors.getOrDefault(e[1], mutableSetOf())
                vertices.add(e[0])
                neighbors[e[1]] = vertices
            }

            val distances = hashMapOf<Pair<Int, Int>, Int>()
            val visited = hashSetOf<Int>()

            fun findDistance(i:Int, j:Int):Int {
                if (i==j) {
                    return 0
                }

                val key1 = Pair(i, j)
                if (distances.contains(key1)) {
                    return distances[key1]!!
                }
                val key2 = Pair(j, i)
                if (distances.contains(key2)) {
                    return distances[key2]!!
                }

                visited.add(i)
                var distance = -1
                val vertices = neighbors.getOrDefault(i, mutableSetOf())
                for (v in vertices) {
                    if (visited.contains(v)) {
                        continue
                    }
                    val d = findDistance(v, j)
                    if (d==-1) {
                        continue
                    }
                    distance = 1 + d
                    break
                }
                if (distance>=0) {
                    distances[key1] = distance
                    distances[key2] = distance
                }
                visited.remove(i)
                return distance
            }

            val sum = IntArray(n)
            for (i in 0..n-1) {
                var d = 0
                for (j in 0..n-1) {
                    d += findDistance(i,j)
                }
                sum[i]=d
            }
            return sum
        }
    }
}