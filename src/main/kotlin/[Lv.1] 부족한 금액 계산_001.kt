import kotlin.math.abs

/**
 * 이용료 price
 * 횟수 N
 * 각 이용료 price * N
 *
 * @return 현재 자산에서 부족한 금액
 * */
class Solution001 {
    fun solution(price: Int, money: Int, count: Int): Long
    = (1..count).sumOf {
        it * price.toLong()
    }.let { if (money > it) 0 else it - money }
}

fun main() {
    val result = Solution001().solution(3, 20, 4)
    println(result)
}
