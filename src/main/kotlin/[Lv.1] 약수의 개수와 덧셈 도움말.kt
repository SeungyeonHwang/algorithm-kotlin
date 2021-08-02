/**
 * - left, right
 * - left ~ right 의 수 중에서 약수의 개수 짝수 -> +
 * - 홀수 -> -

 * @return
 * */
class Solution5 {
    fun solution(left: Int, right: Int): Int {
        return (left..right).map { i ->
            if ((1..i).filter { i % it == 0 }.size % 2 == 0) {
                i
            } else {
                -i
            }
        }.sum()
    }
}

fun main() {
    val result = Solution5().solution(13, 17)
    println(result)
}
