package solution

import solution.annotation.Leetcode
import java.beans.beancontext.BeanContextServiceAvailableEvent

class Solution1255 {
    @Leetcode(1255)
    class Solution {
        fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
            var maxScore = 0
            val initialLetters = hashMapOf<Char, Int>()
            for (c in letters) {
                initialLetters[c] = initialLetters.getOrDefault(c, 0) + 1
            }

            val wordLetterCount = hashMapOf<String, HashMap<Char, Int>>()
            for (w in words) {
                val map = HashMap<Char, Int>()
                for (c in w) {
                    map[c] = map.getOrDefault(c, 0) + 1
                }
                wordLetterCount[w] = map
            }

            fun isWordAvailable(word: String, letterMap: HashMap<Char, Int>): Boolean {
                val count = wordLetterCount[word]!!
                for (c in count.keys) {
                    if (count.getOrDefault(c, 0) > letterMap.getOrDefault(c, 0)) {
                        return false
                    }
                }
                return true
            }

            fun getScore(s: String): Int {
                return s.fold(0) { sum, c -> sum + score[c-'a']}
            }

            val selected = arrayListOf<String>()

            fun addNextWord(availables: List<String>, curLetters: HashMap<Char, Int>) {
                if (availables.isEmpty()) {
                    val curScore = selected.fold(0) { sum, s -> sum + getScore(s) }
                    maxScore = kotlin.math.max(maxScore, curScore)
                    return
                }

                for (i in availables.indices) {
                    val s = availables[i]
                    selected.add(s)
                    val nextAvailables = availables.toMutableList()
                    nextAvailables.removeAt(i)

                    val m1 = wordLetterCount[s]!!
                    for (k in m1.keys) {
                        curLetters[k] = curLetters[k]!! - m1[k]!!
                    }

                    addNextWord(nextAvailables.filter { isWordAvailable(it, curLetters) }, curLetters)

                    for (k in m1.keys) {
                        curLetters[k] = curLetters[k]!! + m1[k]!!
                    }
                    selected.removeAt(selected.size - 1)
                }
            }

            addNextWord(words.filter { isWordAvailable(it, initialLetters) }, initialLetters)

            return maxScore
        }
    }
}