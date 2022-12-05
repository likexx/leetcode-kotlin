package solution

import solution.annotation.Leetcode

class Solution2130 {
    @Leetcode(2130)
    class Solution {
        fun pairSum(head: ListNode?): Int {
            val s = mutableListOf<Int>()
            var p1 : ListNode? = head
            var p2 : ListNode? = head
            while (p2?.next != null) {
                p2 = p2.next!!.next
                s.add(p1!!.value)
                p1 = p1!!.next
            }

            var maxSum = 0
            while (p1 != null) {
                maxSum = kotlin.math.max(maxSum, s.last() + p1.value)
                s.removeAt(s.size-1)
                p1=p1.next
            }
            return maxSum
        }
    }
}