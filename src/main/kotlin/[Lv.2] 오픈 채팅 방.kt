import java.lang.StringBuilder
import kotlin.math.abs

/**
 * 오픈채팅 관리자 창
 * - 입출력 메세지
 *
 */
class S002 {
    fun solution(record: Array<String>): Array<Any> {
        var answer = arrayOf<Any>()

        record.forEach {
            val history = it.split(" ")

            val (id, name) = when (history.size) {
                3 -> Pair(history[1], history[2])
                else -> Pair(history[1], null)
            }

            answer += when (history.first()) {
                "Enter" -> {
                    when (name?.isNotEmpty()) {
                        true -> ("${name}님이 들어왔습니다.")
                        else -> ("${this.findNameById(record, id)}님이 들어왔습니다.")
                    }

                }
                "Leave" -> ("${name}님이 나갔습니다.")
                else -> "${this.findNameById(record, id)}님이 이름 변경."
            }
        }

        return answer
    }

    private fun findNameById(record: Array<String>, id: String): String {
        val userHistory = record.filter {
            it.split(" ")[1] == id
        }

        return userHistory
    }
}

fun main() {
    val result = S002().solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )
    result.forEach {
        println(it)
    }
}