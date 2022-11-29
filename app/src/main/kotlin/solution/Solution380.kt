package solution

import solution.annotation.Leetcode

class Solution380 {
    @Leetcode(380)
    class RandomizedSet() {
        private val nums = hashMapOf<Int, Int>()
        private val indexes = arrayListOf<Int>()

        fun insert(`val`: Int): Boolean {
            val v = `val`
            if (nums.contains(v)) {
                return false
            }
            indexes.add(v)
            nums[v] = indexes.size - 1
            return true
        }

        fun remove(`val`: Int): Boolean {
            val v = `val`
            if (!nums.contains(v)) {
                return false
            }
            val i = nums[v]!!
            val last = indexes.last()
            indexes[i] = last
            indexes.removeAt(indexes.size - 1)
            nums[last]=i

            nums.remove(v)
            return true
        }

        fun getRandom(): Int {
            val i = kotlin.random.Random.nextInt(0, nums.size)
            return indexes[i]
        }

    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * var obj = RandomizedSet()
     * var param_1 = obj.insert(`val`)
     * var param_2 = obj.remove(`val`)
     * var param_3 = obj.getRandom()
     */
}