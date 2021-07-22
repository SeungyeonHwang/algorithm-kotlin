import kotlin.math.abs

/**
 * - 글자를 못알아 볼 경우
 * - 당첨 가능 최고, 최저
 * - 0 ~ 45
 * - 0은 알아볼 수 없는 숫자
 *
 *
1	6개 번호가 모두 일치
2	5개 번호가 일치
3	4개 번호가 일치
4	3개 번호가 일치
5	2개 번호가 일치

 * @return
 * */
class Solution3 {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        return intArrayOf(
            (lottos.size.plus(1)) - lottos.filter { winNums.contains(it) || it == 0 }.size,
            (lottos.size.plus(1)) - lottos.filter(winNums::contains).size
        ).map { if (it > 6) it - 1 else it }.toIntArray()
    }
}
    fun main() {
        val result = Solution3().solution(intArrayOf(0, 0, 0, 0, 0, 0), intArrayOf(38, 19, 20, 40, 15, 25))
        result.forEach {
            println(it)
        }
    }
