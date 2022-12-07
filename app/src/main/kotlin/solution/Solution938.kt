package solution

import solution.annotation.Leetcode

class Solution938 {
    @Leetcode(938)
    class Solution {
        fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
            if (root == null) {
                return 0
            }

            var result = 0
            val s = mutableListOf<TreeNode?>()
            s.add(root)
            while (s.isNotEmpty()) {
                val p = s.last()
                s.removeAt(s.size - 1)
                if (p == null) {
                    continue
                }

                val v = p!!.value
                if (low <= v && v <= high) {
                    result += v
                }

                if (low < v) {
                    s.add(p.left)
                }
                if (v < high) {
                    s.add(p.right)
                }
            }

            return result
        }

        fun rangeSumBST_Preorder(root: TreeNode?, low: Int, high: Int): Int {
            // preorder iteration for bst
            val nums = mutableListOf<Int>()

            var p = root
            var s = mutableListOf<TreeNode>()

            while (p != null || s.isNotEmpty()) {
                while (p != null) {
                    s.add(p)
                    p = p.left
                }

                p = s.last()
                s.removeAt(s.size - 1)
                if (p.value > high) {
                    break
                }

                if (p.value >= low) {
                    nums.add(p.value)
                }

                p = if (p.right != null) { p.right } else { null }
            }

            return nums.fold(0) { r, t -> r + t }
        }
    }
}