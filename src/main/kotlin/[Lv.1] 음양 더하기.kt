import kotlin.math.abs
import kotlin.math.sign

/**
 * - true -> +
 * - false -> -
 * @return sum
 * */
class Solution4 {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int =
        absolutes.foldIndexed(0) {index, acc, i -> acc + if (signs[index]) i else -i }
}

fun main() {
    val result = Solution4().solution(intArrayOf(4, 7, 12), booleanArrayOf(true, false, true))
    println(result)
}

