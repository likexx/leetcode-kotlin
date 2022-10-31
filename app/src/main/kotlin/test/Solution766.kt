package test

class Solution766 : LeetcodeSolution {
    override val level = LeetcodeSolution.Level.MEDIUM
    override val link = "https://leetcode.com/problems/toeplitz-matrix/"
    
    class Solution {
        fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
            val m=matrix.size
            val n=matrix[0].size
            
            val points = mutableListOf<Pair<Int, Int>>()
            for (i in 0..m-1) {
                points.add(Pair(i,0))
            }
            for (j in 1..n-1) {
                points.add(Pair(0,j))
            }
            
            for ((i,j) in points) {
                val v = matrix[i][j]
                var ni=i+1
                var nj=j+1
                while (ni<m && nj<n) {
                    if (matrix[ni][nj]!=v) {
                        return false
                    }
                    ni+=1
                    nj+=1
                }
            }
            
            return true
        }
    }
}