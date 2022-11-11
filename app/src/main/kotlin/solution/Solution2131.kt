package solution

import solution.annotation.Leetcode
import kotlin.math.*

class Solution2131 {
    @Leetcode(2131)
    class Solution {
        fun longestPalindrome(words: Array<String>): Int {
            val counter = hashMapOf<String, Int>()
            var totalLength = 0
            for (w in words) {
                if (counter.getOrDefault(w, 0) == 0) {
                    val k = "${w[1]}${w[0]}"
                    counter[k] = counter.getOrDefault(k, 0) + 1
                } else {
                    totalLength+=4
                    counter[w] = counter[w]!!-1
                }
            }
            for (k in counter.keys) {
                if (k[0]==k[1] && counter[k]==1) {
                    totalLength+=2
                    break
                }
            }
            return totalLength
        }

        fun longestPalindromeOriginal(words: Array<String>): Int {
            val counter= hashMapOf<String, Int>()
            val selfPalindrome = mutableSetOf<String>()

            for (w in words) {
                counter.putIfAbsent(w, 0)
                counter[w] = counter[w]!!+1
                if (w[0]==w[1]) {
                    selfPalindrome.add(w)
                }
            }

            var totalLength=0
            for (k in counter.keys) {
                val expect = "${k[1]}${k[0]}"
                if (counter.getOrDefault(expect, 0) == 0) {
                    continue
                }

                if (expect != k) {
                    val cost = min(counter[k]!!, counter[expect]!!)
                    totalLength += 2*cost
                    counter[k] = counter[k]!! - cost
                    counter[expect] = counter[expect]!! - cost
                } else {
                    val cost = counter[k]!!/2
                    totalLength += 2*cost
                    counter[k] = counter[k]!! - cost*2
                }
            }

            for (w in selfPalindrome) {
                if (counter.getOrDefault(w, 0) > 0) {
                    totalLength+=1
                    break
                }
            }

            return totalLength*2
        }
    }
}
