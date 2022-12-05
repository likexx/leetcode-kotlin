package solution

import solution.annotation.Leetcode

class Solution876 {
    @Leetcode(876)
    class Solution {
        fun middleNode(head: ListNode?): ListNode? {
            var p1 = head
            var p2 = head
            if (p1 == null) {
                return null
            }

            while (p2 != null && p2.next != null) {
                p2 = p2.next!!.next
                p1 = p1!!.next
            }

            return p1
        }
    }
}