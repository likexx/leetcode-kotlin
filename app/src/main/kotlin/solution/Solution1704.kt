package solution

import solution.annotation.Leetcode

class Solution1704 {
    @Leetcode(1704)
    class Solution {
        fun halvesAreAlike(s: String): Boolean {
            val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
            var i=0
            var j=s.length-1
            var count1=0
            var count2=0
            while (i<j) {
                if (vowels.contains(s[i])) {
                    count1+=1
                }
                if (vowels.contains(s[j])) {
                    count2+=1
                }
                i+=1
                j-=1
            }
            return count1 == count2
        }
    }
}