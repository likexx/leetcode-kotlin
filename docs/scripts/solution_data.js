const LeetcodeSolutionList = {"901":{"id":901,"level":"MEDIUM","link":"https://leetcode.com/problems/online-stock-span/","rating":1708,"hint":"monotonic stack, O(n)"},"1926":{"id":1926,"level":"MEDIUM","link":"https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/","rating":1638,"hint":"BFS"},"263":{"id":263,"level":"EASY","link":"https://leetcode.com/problems/ugly-number/","rating":0,"hint":null},"1544":{"id":1544,"level":"EASY","link":"https://leetcode.com/problems/make-the-string-great/","rating":1344,"hint":"stack"},"523":{"id":523,"level":"MEDIUM","link":"https://leetcode.com/problems/continuous-subarray-sum/","rating":0,"hint":null},"907":{"id":907,"level":"MEDIUM","link":"https://leetcode.com/problems/sum-of-subarray-minimums/","rating":1975,"hint":"monotonic stack, follow up to 2104."},"1551":{"id":1551,"level":"MEDIUM","link":"https://leetcode.com/problems/minimum-operations-to-make-array-equal/","rating":1293,"hint":"for nums[i] and nums[j], the number of operations to make them equal is j-i ( ((2*j+1)-(2*i+1))/2 ).  Based on the observation, we can come up with a 2-pointers O(n) solution by adding up all operation counts until i==j. To make it better, we can observe the operation counts in the loop. They are arithmetic sequence [0/1, 3, 5, 7,...,n-1]. Note the first number should be either 0 (if n is odd, the middle number doesn't change) or 1 (if n is even).\n"},"914":{"id":914,"level":"EASY","link":"https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/","rating":1370,"hint":null},"2454":{"id":2454,"level":"HARD","link":"https://leetcode.com/problems/next-greater-element-iv/","rating":2175,"hint":"stack"},"1047":{"id":1047,"level":"EASY","link":"https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/","rating":1286,"hint":"stack, O(n)"},"279":{"id":279,"level":"MEDIUM","link":"https://leetcode.com/problems/perfect-squares/","rating":0,"hint":"dp, O(n*sqrt(n))"},"26":{"id":26,"level":"EASY","link":"https://leetcode.com/problems/remove-duplicates-from-sorted-array/","rating":0,"hint":null},"38":{"id":38,"level":"MEDIUM","link":"https://leetcode.com/problems/count-and-say/","rating":0,"hint":null},"1704":{"id":1704,"level":"EASY","link":"https://leetcode.com/problems/determine-if-string-halves-are-alike/","rating":1207,"hint":null},"41":{"id":41,"level":"HARD","link":"https://leetcode.com/problems/first-missing-positive/","rating":0,"hint":"use sign as flag for existence without losing original positive integer information"},"1706":{"id":1706,"level":"MEDIUM","link":"https://leetcode.com/problems/where-will-the-ball-fall/","rating":1764,"hint":null},"42":{"id":42,"level":"HARD","link":"https://leetcode.com/problems/trapping-rain-water/","rating":0,"hint":"monotonous stack (decreasing), similar to question 84 (https://leetcode.com/problems/largest-rectangle-in-histogram/)"},"938":{"id":938,"level":"EASY","link":"https://leetcode.com/problems/range-sum-of-bst/","rating":1335,"hint":"either dfs or preorder works at similar performance. dfs is more concise."},"1323":{"id":1323,"level":"EASY","link":"https://leetcode.com/problems/maximum-69-number/","rating":1193,"hint":null},"2095":{"id":2095,"level":"MEDIUM","link":"https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/","rating":1324,"hint":null},"1328":{"id":1328,"level":"MEDIUM","link":"https://leetcode.com/problems/break-a-palindrome/","rating":1473,"hint":null},"433":{"id":433,"level":"MEDIUM","link":"https://leetcode.com/problems/minimum-genetic-mutation/","rating":0,"hint":null},"49":{"id":49,"level":"MEDIUM","link":"https://leetcode.com/problems/group-anagrams/","rating":0,"hint":null},"1201":{"id":1201,"level":"MEDIUM","link":"https://leetcode.com/problems/ugly-number-iii/","rating":2039,"hint":"lcm, gcd, binary-search. For Java/Kotlin, use Long instead of Int"},"2225":{"id":2225,"level":"MEDIUM","link":"https://leetcode.com/problems/find-players-with-zero-or-one-losses/","rating":1316,"hint":null},"947":{"id":947,"level":"MEDIUM","link":"https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/","rating":2034,"hint":"union find"},"692":{"id":692,"level":"MEDIUM","link":"https://leetcode.com/problems/top-k-frequent-words/","rating":0,"hint":null},"1207":{"id":1207,"level":"EASY","link":"https://leetcode.com/problems/unique-number-of-occurrences/","rating":1195,"hint":null},"952":{"id":952,"level":"HARD","link":"https://leetcode.com/problems/largest-component-size-by-common-factor/","rating":2272,"hint":"factor decomposition + union find of factors + hashmap"},"2104":{"id":2104,"level":"MEDIUM","link":"https://leetcode.com/problems/sum-of-subarray-ranges/","rating":1504,"hint":"two monotonic stacks, O(n)"},"835":{"id":835,"level":"MEDIUM","link":"https://leetcode.com/problems/image-overlap/","rating":1969,"hint":null},"325":{"id":325,"level":"MEDIUM","link":"https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/","rating":0,"hint":null},"328":{"id":328,"level":"MEDIUM","link":"https://leetcode.com/problems/odd-even-linked-list/","rating":0,"hint":null},"331":{"id":331,"level":"MEDIUM","link":"https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/","rating":0,"hint":null},"334":{"id":334,"level":"MEDIUM","link":"https://leetcode.com/problems/increasing-triplet-subsequence/","rating":0,"hint":null},"976":{"id":976,"level":"EASY","link":"https://leetcode.com/problems/largest-perimeter-triangle/","rating":1340,"hint":null},"2128":{"id":2128,"level":"MEDIUM","link":"https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/","rating":0,"hint":"using gcd for best optimized solution"},"337":{"id":337,"level":"MEDIUM","link":"https://leetcode.com/problems/house-robber-iii/","rating":0,"hint":null},"2130":{"id":2130,"level":"MEDIUM","link":"https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/","rating":1317,"hint":null},"84":{"id":84,"level":"HARD","link":"https://leetcode.com/problems/largest-rectangle-in-histogram/","rating":0,"hint":"monotonous stack, increasing"},"981":{"id":981,"level":"MEDIUM","link":"https://leetcode.com/problems/time-based-key-value-store/","rating":1574,"hint":null},"1239":{"id":1239,"level":"MEDIUM","link":"https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/","rating":1719,"hint":null},"343":{"id":343,"level":"MEDIUM","link":"https://leetcode.com/problems/integer-break/","rating":0,"hint":null},"345":{"id":345,"level":"EASY","link":"https://leetcode.com/problems/reverse-vowels-of-a-string/","rating":0,"hint":null},"223":{"id":223,"level":"MEDIUM","link":"https://leetcode.com/problems/rectangle-area/","rating":0,"hint":"interval overlapping problem"},"351":{"id":351,"level":"MEDIUM","link":"https://leetcode.com/problems/android-unlock-patterns/","rating":0,"hint":null},"353":{"id":353,"level":"MEDIUM","link":"https://leetcode.com/problems/design-snake-game/","rating":0,"hint":null},"355":{"id":355,"level":"MEDIUM","link":"https://leetcode.com/problems/design-twitter/","rating":0,"hint":null},"356":{"id":356,"level":"MEDIUM","link":"https://leetcode.com/problems/line-reflection/","rating":0,"hint":null},"1255":{"id":1255,"level":"HARD","link":"https://leetcode.com/problems/maximum-score-words-formed-by-letters/","rating":1881,"hint":"DFS is straightforward with some optimizations. It could be solved using DP similar to knapsack problem, but I don't see much improvement in this case."},"1003":{"id":1003,"level":"MEDIUM","link":"https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/","rating":1426,"hint":"stack for O(n)"},"876":{"id":876,"level":"EASY","link":"https://leetcode.com/problems/middle-of-the-linked-list/","rating":1231,"hint":null},"1392":{"id":1392,"level":"HARD","link":"https://leetcode.com/problems/longest-happy-prefix/","rating":1876,"hint":"prefix calculating in KMP using DP. Details can be found at https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching"},"1657":{"id":1657,"level":"MEDIUM","link":"https://leetcode.com/problems/determine-if-two-strings-are-close/","rating":1530,"hint":"compare the frequency domain counter. Try to take only O(1) space."},"380":{"id":380,"level":"MEDIUM","link":"https://leetcode.com/problems/insert-delete-getrandom-o1/","rating":0,"hint":"hashmap + arraylist, kind like LRU"},"766":{"id":766,"level":"MEDIUM","link":"https://leetcode.com/problems/toeplitz-matrix/","rating":1249,"hint":null},"1662":{"id":1662,"level":"EASY","link":"https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/","rating":1217,"hint":null}}