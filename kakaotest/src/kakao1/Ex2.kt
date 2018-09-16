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

    // 결과 리턴

    return score
}





