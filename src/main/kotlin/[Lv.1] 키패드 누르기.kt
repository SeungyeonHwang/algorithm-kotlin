import kotlin.math.abs

/**
 * - 왼손, 오른손만 이용
 * - 왼손(*) , 오른손(#) 시작
 * - 상하좌우, 1칸씩
 * - 1,4,7 -> 왼손
 * - 3,6,9 -> 오른손
 * - 2,5,8,0 -> 현재 키패드에서 가까운 엄지, 거리 동일 -> 오른/왼손 잡이에 따라 사용
 * @return R/L list
 * */
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""

        val map = mutableMapOf(
            1 to Pair(0, 3),
            2 to Pair(1, 3),
            3 to Pair(2, 3),
            4 to Pair(0, 2),
            5 to Pair(1, 2),
            6 to Pair(2, 2),
            7 to Pair(0, 1),
            8 to Pair(1, 1),
            9 to Pair(2, 1),
            0 to Pair(1, 0),
            "*" to Pair(0, 0),
            "#" to Pair(2, 0)
        )

        var currentL: Any = "*"
        var currentR: Any = "#"

        fun Pair<Int, Int>.distance(pair: Pair<Int, Int>): Int =
            abs(this.first - pair.first) + abs(this.second - pair.second)

        numbers.forEach {
            if (it == 1 || it == 4 || it == 7) {
                answer += "L"
                currentL = it

            } else if (it == 3 || it == 6 || it == 9) {
                answer += "R"
                currentR = it

            } else {
                val distanceFromCurrentL = map[it]!!.distance(map[currentL]!!)
                val distanceFromCurrentR = map[it]!!.distance(map[currentR]!!)

                    if (distanceFromCurrentL > distanceFromCurrentR) {
                        answer += "R"
                        currentR = it
                    } else if (distanceFromCurrentL < distanceFromCurrentR) {
                        answer += "L"
                        currentL = it
                    } else {
                        if (hand == "right") {
                            answer += "R"
                            currentR = it
                        } else if(hand == "left") {
                            answer += "L"
                            currentL = it
                        }
                    }
            }
        }
        return answer
    }
}

fun main() {
    val result = Solution().solution(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left")
    println(result)
}