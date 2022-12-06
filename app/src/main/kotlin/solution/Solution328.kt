package solution

import solution.annotation.Leetcode

class Solution328 {
    @Leetcode(328)
    class Solution {
        fun oddEvenList(head: ListNode?): ListNode? {
            if (head == null) {
                return null
            }

            val h1 = head!!
            val h2 = head.next
            var p1 = h1
            var p2 = h2
            while (p2?.next != null) {
                p1.next = p2.next
                p2.next = p2.next?.next
                p1 = p1.next!!
                p2 = p2.next
            }
            p1.next = h2

            return h1
        }
    }
}