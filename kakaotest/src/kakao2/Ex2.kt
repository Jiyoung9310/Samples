package kakao2

fun main(args: Array<String>) {
    val N = 10
    val record = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
    val result = solution(N, record)

    println("결과: "+result)
}

fun solution(N: Int, stages: IntArray): IntArray {
    // 스테이지별로 도전 인원수를 구한다
    // 실패율을 측정한다
    val failure = getPlayerCount(N, stages)
    // 실패율이 높은 스테이지부터 내림차순으로 sorting
    val result = failure.toList().sortedByDescending { (_, value) -> value}.toMap()
    // 결과 반환
    var answer = mutableListOf<Int>()
    for (entry in result) {
        answer.add(entry.key+1)
    }
    println(answer)
    return answer.toIntArray()
}

private fun getPlayerCount(N: Int, stages: IntArray): MutableMap<Int, Float> {
    val player = Array(N+1,{0})
    val current = Array(N+1, {0})
    for (i in stages) {
        current[i-1]++
        for(j in 0 until i) {
            player[j]++
        }
    }

    return getFailure(current, player)
}

private fun getFailure(current: Array<Int>, player: Array<Int>): MutableMap<Int, Float> {
    val failure = mutableMapOf<Int, Float>()
    for(i in 0 until current.size-1) {
        if(player[i] != 0) {
            failure[i] = (current[i].toFloat() / player[i].toFloat())
        } else {
            failure[i] = 0F
        }
    }
    return failure
}