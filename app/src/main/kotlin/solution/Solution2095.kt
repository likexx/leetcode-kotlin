package solution

class Solution2095 {
    class Solution {
        fun deleteMiddle(head: ListNode?): ListNode? {
            var fast=head
            var slow: ListNode? = null

            while (fast!=null && fast.next!=null) {
                fast=fast?.next?.next
                if (slow==null) {
                    slow=head
                } else {
                    slow=slow.next
                }
            }
            if (slow!=null && slow.next != null) {
                slow.next=slow?.next?.next
            }

            if (fast==head) {
                return head
            }
            if (slow==null) {
                return null
            }
            return head
        }
    }
}