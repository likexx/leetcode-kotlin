package solution

import solution.annotation.Leetcode

class Solution96 {
    @Leetcode(96)
    class Solution {
        fun restoreIpAddresses(s: String): List<String> {
            val result = mutableListOf<String>()

            fun dfs(start: Int, addresses: MutableList<String>) {
                if (start == s.length) {
                    if (addresses.size == 4) {
                        result.add(addresses.joinToString("."))
                    }
                    return
                }

                for (i in start+1..kotlin.math.min(start+3, s.length)) {
                    val curAddr = s.substring(start, i)
                    if (curAddr.length >= 2 && curAddr[0]=='0') {
                        break
                    }
                    if (curAddr.length == 3 && curAddr.toInt() > 255) {
                        break
                    }
                    addresses.add(curAddr)
                    dfs(i, addresses)
                    addresses.removeAt(addresses.size - 1)
                }
            }

            dfs(0, mutableListOf())
            return result
        }
    }
}