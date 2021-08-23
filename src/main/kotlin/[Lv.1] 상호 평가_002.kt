import java.lang.StringBuilder
import kotlin.math.abs

/**
 * 상호 평가
 * 자신이 자기를 평가할 경우, 유일한 최고점/유일한 최저점 이라면, 무효처리 -> 평균
 *
 * @return 학점 -> Score -> 문자열
 * */
class Solution002 {
    fun solution(scores: Array<IntArray>): String {
        val answer = StringBuilder()

        scores.indices.map { stdNum ->
            val currentStdScore = scores.map { it[stdNum] }
            val max = currentStdScore.maxOrNull()
            val min = currentStdScore.minOrNull()
            var ignoreFlag = false

            if (currentStdScore[stdNum] == max && currentStdScore.count { it == max } == 1) {
                ignoreFlag = true
            } else if (currentStdScore[stdNum] == min && currentStdScore.count { it == min } == 1) {
                ignoreFlag = true
            }

            currentStdScore.toMutableList().apply {
                if (ignoreFlag)
                    removeAt(stdNum)
                when(average()){
                    in 90.0..100.0 -> answer.append("A")
                    in 80.0..90.0 -> answer.append("B")
                    in 70.0..80.0 -> answer.append("C")
                    in 50.0..70.0 -> answer.append("D")
                    else -> answer.append("F")
                }
            }
        }

        return answer.toString()
    }
}

fun main() {
    val result = Solution002().solution(
        arrayOf(
            intArrayOf(100, 90, 98, 88, 65),
            intArrayOf(50, 45, 99, 85, 77),
            intArrayOf(47, 88, 95, 80, 67),
            intArrayOf(61, 57, 100, 80, 65),
            intArrayOf(24, 90, 94, 75, 65),
        )
    )
    println(result)
}
