/**
 * 직업군 언어점수 table (내림 차순)
 * 언어 language
 * 언어 선호도 prefrence
 *
 * @return 언어 선호도 * 직업군 언어 점수 높은 직업군
 * */
class Solution003 {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
        val score = mutableListOf<Pair<Int, String>>()
        for (t in table) {
            val list = t.split(" ")
            var sum = 0
            for (l in 1..list.lastIndex) {
                for (i in languages.indices) {
                    if (list[l] == languages[i]) {
                        sum += preference[i] * (6 - l)
                    }
                }
            }
            score.add(Pair(sum, list[0]))
        }
        if (score.isEmpty()) {
            languages.sort()
            return languages[0]
        }

        score.sortWith(compareByDescending<Pair<Int, String>> { it.first }.thenBy { it.second })
        return score.first().second
    }
}


fun main() {
    val result = Solution003().solution(
        arrayOf(
            "SI JAVA JAVASCRIPT SQL PYTHON C#",
            "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
            "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
            "GAME C++ C# JAVASCRIPT C JAVA"
        ),
        arrayOf("JAVA", "JAVASCRIPT"), intArrayOf(7, 5)
    )
    println(result)
}
