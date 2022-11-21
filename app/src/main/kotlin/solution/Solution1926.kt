package solution

import solution.annotation.Leetcode

class Solution1926 {
    @Leetcode(1926)
    class Solution {
        fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
            val M = maze.size
            val N = maze[0].size

            val q = mutableListOf<IntArray>()
            val visited = mutableSetOf<Pair<Int, Int>>()
            q.add(intArrayOf(entrance[0], entrance[1], 0))
            visited.add(Pair(entrance[0], entrance[1]))

            while (q.isNotEmpty()) {
                val (y, x, steps) = q[0]
                q.removeAt(0)

                if ((y==0 || x == 0 || y==M-1 || x==N-1) && (y != entrance[0] || x != entrance[1])) {
                    return steps
                }

                for (next in arrayOf(Pair(y,x-1), Pair(y,x+1), Pair(y-1, x), Pair(y+1, x))) {
                    val ny=next.first
                    val nx=next.second
                    if (ny<0 || nx<0 || ny>=M || nx>=N || (ny==entrance[0] && nx==entrance[1])
                        || maze[ny][nx]!='.' || visited.contains(next)) {
                        continue
                    }
                    q.add(intArrayOf(ny, nx, steps+1))
                    visited.add(next)
                }

            }

            return -1
        }
    }
}