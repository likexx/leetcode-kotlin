package test

import test.annotation.Leetcode

class Solution901 {
    @Leetcode(901)
    class StockSpanner() {
        var stack = mutableListOf<Pair<Int, Int>>()

        fun next(price: Int): Int {
            var span = 0
            while (stack.size>0 && stack.last().first <= price) {
                val last = stack.removeAt(stack.size-1)
                span += last.second
            }
            span+=1
            stack.add(Pair(price, span))
            return span
        }
    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * var obj = StockSpanner()
     * var param_1 = obj.next(price)
     */
}