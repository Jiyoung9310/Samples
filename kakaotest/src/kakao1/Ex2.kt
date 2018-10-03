package kakao1

import java.util.regex.Pattern

//다트게임
fun main(args: Array<String>) {
    val dartResult = "10S2D*3T"
    val result = solution(dartResult)

    println("결과: $result")
}

fun solution(dartResult: String): List<String> {

    val score = mutableListOf<String>()
    // 1. 점수 1,2,3을 추출한다 - 정규표현식
    // ([0-10][S|D|T][][\*|\#]?){3}
    val regex = "([0-9]*[S|D|T][\\*|\\#]?)"
    val groupMatcher = Pattern.compile(regex).matcher(dartResult)
    while(groupMatcher.find()) {
        score.add(groupMatcher.group())
        println(groupMatcher.group())
    }
    // 점수를 계산한다.
    var result = 0
    for(s in score) {
        val p = Pattern.compile("(^[0-9]*$)").matcher(s).group().toInt()
        if(s.contains('S')) {
            result = p
        } else if (s.contains('D')) {
            result = p * p
        } else if (s.contains('T')) {
            result = p * p * p
        }
    }

    // 결과 리턴

    return score
}






