package solution

import solution.annotation.Leetcode

class Solution835 {
    @Leetcode(835)
    class Solution {
        fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
            val n = img1.size
            val dots1= mutableSetOf<Int>()
            val dots2= mutableSetOf<Int>()

            for (i in 0..n-1) {
                for (j in 0..n-1) {
                    if (img1[i][j]==1) {
                        dots1.add(i*n+j)
                    }
                    if (img2[i][j]==1) {
                        dots2.add(i*n+j)
                    }
                }
            }
            println("original: $dots1")
            var maxCount=0
            for (dy in -n..n) {
                for (dx in -n..n) {
                    val translated = dots1.map {
                        var i=it/n
                        var j=it%n
                        i+=dy
                        j+=dx
                        if (i<0 || i>=n || j<0 || j>=n) {
                            -1
                        } else {
                            i*n+j
                        }
                    }.filter { it>=0 }.toHashSet()

                    var count=0
                    dots2.forEach {
                        if (translated.contains(it)) {
                            count+=1
                        }
                    }
                    maxCount = kotlin.math.max(maxCount, count)
                }
            }
            return maxCount
        }
    }
}

