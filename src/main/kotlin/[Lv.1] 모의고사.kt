import kotlin.math.abs

/**
 * - 1번 : 1, 2, 3, 4, 5
 * - 2번 : 2, 1, 2, 3, 2, 4, 2, 5
 * - 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
 * - 정답 배열 answer
 * - 여러 사람일 경우 , 동점자 -> 오름차순 정렬
 * @return 가장 많은 문제를 맞힌사람
 * */
class Solution2 {
    fun solution(answer: IntArray): IntArray {

        val one = arrayOf(1, 2, 3, 4, 5)
        val two = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val three = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val score = arrayOf(0, 0, 0)
        val result = arrayListOf<Int>()

        answer.forEachIndexed { index, i ->

            if (one[index.rem(one.size)] == i) score[0]++
            if (two[index.rem(two.size)] == i) score[1]++
            if (three[index.rem(three.size)] == i) score[2]++


        }
        if (score[0] == score.maxOrNull()) result.add(1)
        if (score[1] == score.maxOrNull()) result.add(2)
        if (score[2] == score.maxOrNull()) result.add(3)

        return result.toIntArray()
    }
}

fun main() {
    val result = Solution2().solution(intArrayOf(1, 2, 3, 4, 5))
    result.forEach {
        print(it)
    }
}

