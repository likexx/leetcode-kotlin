package test

class Solution976 {
    class Solution {
        fun largestPerimeter(nums: IntArray): Int {
            val sortedNums = nums.sortedDescending()
            for (i in 0..sortedNums.size-1) {
                for (j in i+1..sortedNums.size-2) {
                    if (sortedNums[j+1]+sortedNums[j]>sortedNums[i]) {
                        return sortedNums[i]+sortedNums[j]+sortedNums[j+1]
                    }
                }
            }
            return 0
        }
    }
}