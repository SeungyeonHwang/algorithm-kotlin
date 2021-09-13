import java.lang.StringBuilder
import kotlin.math.abs

/**
 * 오픈채팅 관리자 창
 * - 입출력 메세지
 *
 */
class S002 {
    companion object {
        const val Enter = "님이 들어왔습니다."
        const val Leave = "님이 나갔습니다."
    }

    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        var map = HashMap<String, String>()

        record.forEach {
            when (it.split(" ")[0]) {
                "Enter", "Change" -> {
                    val uid = it.split(" ")[1]
                    val name = it.split(" ")[2]
                    map[uid] = name
                }
            }
        }
        record.forEach {
            when(it.split(" ")[0]) {
                "Enter" -> {
                    answer.add(map[it.split(" ")[1]] + Enter)
                }
                "Leave" -> {
                    answer.add(map[it.split(" ")[1]] + Leave)
                }
            }
        }
        return answer.toTypedArray()
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