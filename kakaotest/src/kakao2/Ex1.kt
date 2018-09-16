package kakao2

const val Keyword_Enter = "Enter"
const val Keyword_Leave = "Leave"
const val Keyword_Change = "Change"

fun main(args: Array<String>) {
    val record = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
    val result = solution(record)

    println("결과: "+result)
}

fun solution(record: Array<String>): Array<String> {
    // 1. 등장한 인원을 Map에 저장
    val userMap = createUser(record)
    // 2. Enter, Leave 키워드로 유저 닉네임과 입장, 퇴장을 표시한다
    // 결과 출력
    var answer = setMessage(record, userMap)
    return answer
}

fun createUser(record: Array<String>): MutableMap<String, String> {
    val userList = mutableMapOf<String, String>()
    for(r in record) {
        val info = r.split(" ")
        if (info[0] == Keyword_Enter || info[0] == Keyword_Change) {
            userList[info[1]] = info[2]
        }
    }
    return userList
}

fun setMessage(record: Array<String>, user: Map<String, String>): Array<String> {
    val message = mutableListOf<String>()
    for(r in record) {
        val info = r.split(" ")
        val keyword = info[0]
        if (keyword == Keyword_Enter || keyword == Keyword_Leave) {
            val uid = info[1]
            val nickname = user[uid]
            val msg = when(keyword) {
                Keyword_Enter -> nickname+"님이 들어왔습니다."
                Keyword_Leave -> nickname+"님이 나갔습니다."
                else -> {
                    ""
                }
            }

            message.add(msg)
        }

    }
    return message.toTypedArray()
}