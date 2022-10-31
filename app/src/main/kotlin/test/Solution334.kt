package test

class Solution334 {
    class Solution {
        fun increasingTriplet(nums: IntArray): Boolean {
            val leftMin= IntArray(nums.size)
            val rightMax=IntArray(nums.size)
            leftMin[0]=nums[0]
            rightMax[rightMax.size-1]=nums[rightMax.size-1]

            for (i in 1..nums.size-1) {
                leftMin[i]=Math.min(leftMin[i-1], nums[i])
            }

            for (i in nums.size-2 downTo 0) {
                rightMax[i]=Math.max(rightMax[i+1], nums[i])
            }

            for (i in 1..nums.size-2) {
                if (leftMin[i]<nums[i] && nums[i]<rightMax[i]) {
                    return true
                }
            }

            return false
        }
    }
}