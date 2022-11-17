package solution

import solution.annotation.Leetcode

class Solution351 {
    @Leetcode(351)
    class Solution {
        fun numberOfPatterns(m: Int, n: Int): Int {
            val cache= hashMapOf<Int, List<List<Int>>>()

            fun find(k:Int): List<List<Int>> {
                if (k==1) {
                    return (1..9).map { listOf(it) }
                }
                if (cache.containsKey(k)) {
                    return cache[k]!!
                }

                var result= mutableListOf<List<Int>>()
                val prev=find(k-1)
                for (arr in prev) {
                    var visited= mutableSetOf<Int>()
                    for (i in arr) {
                        visited.add(i)
                    }
                    var availables = mutableSetOf<Int>()
                    for (i in 1..9) {
                        if (visited.contains(i)) {
                            continue
                        }
                        availables.add(i)
                    }

                    for (j in availables) {
                        val last = arr[arr.size-1]
                        val r1=(last-1)/3
                        val c1=(last-1)%3
                        val r2=(j-1)/3
                        val c2=(j-1)%3

                        var selected=true
                        if (r1==r2) {
                            if (Math.min(c1,c2)+1!=Math.max(c1,c2)) {
                                val mid=Math.min(last,j)+1
                                selected=visited.contains(mid)
                            }
                        } else if (c1==c2) {
                            if (Math.min(r1,r2)+1!=Math.max(r1,r2)) {
                                val mid = (Math.min(r1,r2)+1)*3+c2+1
                                selected=visited.contains(mid)
                            }
                        } else {
                            if ((c1==0 && r1==0 && c2==2 && r2==2)
                                || (c1==2 && r1==0 && c2==0 && r2==2)
                                || (c1==2 && r1==2 && c2==0 && r2==0)
                                || (c1==0 && r1==2 && c2==2 && r2==0)) {
                                selected = visited.contains(5)
                            }
                        }

                        if (selected) {
                            val newArr=arr.toMutableList()
                            newArr.add(j)
                            result.add(newArr)
                        }
                    }
                }
                cache[k]=result
                return result
            }

            var count=0
            for (i in m..n) {
                val res=find(i)
//                println("$i, ${res.size}")
//                println("$res")
                count+=res.size
            }
            return count
        }
    }
}