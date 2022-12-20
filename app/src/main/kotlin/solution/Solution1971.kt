package solution

import solution.annotation.Leetcode

class Solution1971 {
    @Leetcode(1971)
    class Solution {
        fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
            // use union find
            val parent = IntArray(n) { -1 }
            val sizes = IntArray(n) { 1 }

            fun findParent(i: Int): Int {
                if (parent[i] == -1) {
                    return i
                }
                parent[i] = findParent(parent[i])
                return parent[i]
            }

            fun union(i: Int, j: Int) {
                val p1 = findParent(i)
                val p2 = findParent(j)
                if (p1 == p2) {
                    return
                }
                val s1 = sizes[p1]
                val s2 = sizes[p2]
                if (s1 >= s2) {
                    parent[p2] = p1
                    sizes[p1] = sizes[i] + sizes[j]
                } else {
                    parent[p1] = p2
                    sizes[p2] = sizes[j] + sizes[i]
                }
            }

            for (e in edges) {
                union(e[0], e[1])
            }

            return findParent(source) == findParent(destination)
        }

        fun validPath_bfs(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
            val neighbors = hashMapOf<Int, MutableSet<Int>>()
            for (e in edges) {
                var vertices = neighbors.getOrDefault(e[0], mutableSetOf<Int>())
                vertices.add(e[1])
                neighbors[e[0]] = vertices

                vertices = neighbors.getOrDefault(e[1], mutableSetOf<Int>())
                vertices.add(e[0])
                neighbors[e[1]] = vertices
            }

            val q = mutableListOf<Int>(source)
            val visited = mutableSetOf<Int>(source)

            while (!q.isEmpty()) {
                val p = q[0]
                q.removeAt(0)
                if (p == destination) {
                    return true
                }

                if (!neighbors.contains(p)) {
                    continue
                }

                for (v in neighbors[p]!!) {
                    if (visited.contains(v)) {
                        continue
                    }
                    q.add(v)
                    visited.add(v)
                }
            }

            return false
        }
    }
}