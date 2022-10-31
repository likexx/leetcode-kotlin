package test

class Solution38 {
    class Solution {
        fun countAndSay(n: Int): String {
            fun count(s: String): String {
                if (s=="") {
                    return "1"
                }
                var values= mutableListOf<Pair<Int, Char>>()
                var last=s[0]
                var curCount=1
                for (i in 1..s.length-1) {
                    val c=s[i]
                    if (c==last) {
                        curCount+=1
                    } else {
                        values.add(Pair(curCount, last))
                        last=c
                        curCount=1
                    }
                }
                values.add(Pair(curCount, last))

                return buildString {
                    for ((k, c) in values) {
                        append(k.toString())
                        append(c)
                    }
                }
            }

            var s=""
            for (i in 1..n) {
                s=count(s)
            }
            return s
        }
    }
}