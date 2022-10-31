package test

class Solution1328 {
    class Solution {
        fun breakPalindrome(palindrome: String): String {
            if (palindrome.length==1) {
                return ""
            }

            val arr = palindrome.toMutableList()
            var updated=false
            for (i in arr.indices) {
                if (i==arr.size/2) {
                    break
                }
                if (arr[i]!='a') {
                    arr[i]='a'
                    return arr.joinToString("")
                }
            }
            arr[arr.size-1]='b'
            return arr.joinToString("")
        }
    }
}