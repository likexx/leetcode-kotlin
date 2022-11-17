package solution

import solution.annotation.Leetcode

class Solution331 {
    @Leetcode(331)
    class Solution {
        fun isValidSerialization(preorder: String): Boolean {
            if (preorder=="#") {
                return true
            }
            val values=preorder.split(",")
            val count = mutableListOf<Int>()
            for ((i,v) in values.withIndex()) {
                if (i!=0 && count.size==0) {
                    return false
                }
                if (v!="#") {
                    count.add(2)
                } else {
                    while (count.size>0) {
                        count[count.size-1]-=1
                        if (count[count.size-1]==0) {
                            count.removeAt(count.size - 1)
                        } else {
                            break
                        }
                    }
                }
            }
            return count.size==0
        }
    }
}