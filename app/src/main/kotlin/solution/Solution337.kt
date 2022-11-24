package solution

import solution.annotation.Leetcode

class Solution337 {
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    @Leetcode(337)
    class Solution {
        fun rob(root: TreeNode?): Int {
            val cache= mutableMapOf<Pair<TreeNode?, Boolean>, Int>()

            fun take(node: TreeNode?, usingRoot: Boolean): Int {
                if (node==null) {
                    return 0
                }

                val key=Pair(node, usingRoot)
                if (cache.containsKey(key)) {
                    return cache[key]!!
                }

                if (usingRoot) {
                    cache[key] = node?.`val`!! + take(node?.left,false)+take(node?.right,false)
                } else {
                    var v1=take(node?.left, false)+take(node?.right, false)
                    var v2=take(node?.left, true)+take(node?.right, false)
                    var v3=take(node?.left, false)+take(node?.right, true)
                    var v4=take(node?.left, true)+take(node?.right, true)
                    cache[key]= Math.max(Math.max(v1,v2), Math.max(v3,v4))
                }
                return cache[key]!!
            }

            return kotlin.math.max(take(root,true), take(root,false))

         }
    }
}