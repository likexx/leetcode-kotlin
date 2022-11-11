package solution

class Solution353 {
    class SnakeGame(val width: Int, val height: Int, val food: Array<IntArray>) {
        val visited = mutableListOf<Pair<Int, Int>>()
        var head = Pair(0,0)
        var curLength = 0
        var foodIndex = 0

        fun move(direction: String): Int {
            visited.add(Pair(head.first, head.second))

            when (direction) {
                "U" -> head = Pair(head.first-1, head.second)
                "D" -> head = Pair(head.first+1, head.second)
                "L" -> head = Pair(head.first, head.second-1)
                "R" -> head = Pair(head.first, head.second+1)
            }

            if (head.first<0 || head.first>=this.height || head.second<0 || head.second>=this.width) {
                return -1
            }

            if (curLength>0) {
                for (i in visited.size-1 downTo visited.size-curLength) {
                    if (visited[i].first == head.first && visited[i].second == head.second) {
                        return -1
                    }
                }
            }

            if (foodIndex < food.size) {
                if (head.first == food[foodIndex][0] && head.second == food[foodIndex][1]) {
                    curLength += 1
                    foodIndex += 1
                }
            }

            return curLength
        }
    }

    /**
     * Your SnakeGame object will be instantiated and called as such:
     * var obj = SnakeGame(width, height, food)
     * var param_1 = obj.move(direction)
     */
}