package kakao1

import java.util.regex.Pattern

//다트게임
fun main(args: Array<String>) {
    val dartResult = "1S2D*3T"
    val result = solution(dartResult)

    println("결과: $result")
}

fun solution(dartResult: String): Int {

    val score = listOf(1, 1, 1)
    // 1. 점수 1,2,3을 추출한다 - 정규표현식
    // ([0-10][S|D|T][][\*|\#]?){3}
    val regex = "([0-10][S|D|T][\\*|\\#]?)"
    val groupMatcher = Pattern.compile(regex).matcher(dartResult)
    while(groupMatcher.find()) {
        println(groupMatcher.group(1))
    }

    // 결과 리턴

    return 1
}




