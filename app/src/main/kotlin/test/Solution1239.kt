package test

import kotlin.math.max

class Solution1239 : LeetcodeSolution {

    override val level = LeetcodeSolution.Level.MEDIUM
    override val link = "https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/"

    class Solution {
        fun maxLength(arr: List<String>): Int {
            fun isDuplicated(buf: String): Boolean {
                var bits=0
                for (c in buf) {
                    val mask = 1 shl (c-'a')
                    if (bits and mask != 0) {
                        return true
                    }
                    bits = bits or mask
                }
                return false
            }
            fun check(start: Int, selected: String): Int {
                if (isDuplicated(selected)) {
                    return 0
                }

                var maxLen=selected.length
                for (i in start..arr.size-1) {
                    maxLen = kotlin.math.max(maxLen, check(i+1, selected+arr[i]))
                }
                return maxLen
            }

            return check(0, "")
        }
//        fun maxLength(arr: List<String>): Int {
//            val bits= hashMapOf("" to 0)
//
//            val getBits = fun (s:String): Int {
//                if (bits.containsKey(s)) {
//                    return bits[s]!!
//                }
//
//                var v=0
//                for (c in s) {
//                    val offset=c-'a'
//                    v = v or (1 shl offset)
//                }
//                bits[s]=v
//                return v
//            }
//
//            val isSelfDuplicated = fun (s:String): Boolean {
//                var bits=0
//                for (c in s) {
//                    val mask = 1 shl c-'a'
//                    if (mask and bits != 0) {
//                        return true
//                    }
//                    bits = bits or mask
//                }
//                return false
//            }
//
//            var longest = 0
//            fun dfs(start:Int, selected:MutableList<String>) {
//                if (start>=arr.size) {
//                    var len = 0
//                    selected.forEach {len+=it.length}
//                    longest = kotlin.math.max(longest, len)
//                    return
//                }
//
//                var duplicated = false
//                val cur = arr[start]
//
//                if (isSelfDuplicated(cur)) {
//                    dfs(start+1, selected)
//                    return
//                }
//
//                for (s in selected) {
//                    val mask = getBits(s) and getBits(cur)
//                    if (mask!=0) {
//                        duplicated = true
//                        break
//                    }
//                }
//
//                dfs(start+1, selected)
//                if (!duplicated) {
//                    selected.add(cur)
//                    dfs(start+1, selected)
//                    selected.removeAt(selected.size-1)
//                }
//            }
//
//            dfs(0, mutableListOf<String>())
//
//            return longest
//        }
    }
}