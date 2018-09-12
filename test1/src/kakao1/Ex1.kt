package kakao1


fun main(args: Array<String>) {
    val n = 6
    val arr1 = listOf(46, 33, 33 ,22, 31, 50)
    val arr2 = listOf(27 ,56, 19, 14, 14, 10)
    val result = solution(n, arr1, arr2)

    println("결과: $result")
}

fun solution(n: Int, arr1: List<Int>, arr2: List<Int>): List<String> {

    // 1. 두 배열의 같은 인덱스에 위치한 값들끼리 OR연산
    val sumArray = arrayListOf<Int>()
    for(i in 0 until arr1.size) {
        sumArray.add(i, arr1[i] or arr2[i])
        println(sumArray[i])
    }

    // 2. 배열의 각 값을 n의 자리 이진수로 변환
    val binArray = toBinaryArray(sumArray, n)

    // 3. 0 => 공백, 1 => '#' 으로 변환
    val resultArray = arrayListOf<String>()
    binArray.map {
        it.replace("0", " ")
    }.map {
        it.replace("1", "#")
    }.forEach {
        resultArray.add(it)
    }

    // 결과 리턴

    return resultArray
}

fun toBinaryArray(arr: List<Any>, n:Int): List<String> {
    var binArr = arrayListOf<String>()
    arr.map { num ->
        Integer.toBinaryString(num as Int)
    }.map {
        zeroFill(it, n)
    }.forEach{
        println(it)
        binArr.add(it)
    }
    return binArr
}

fun zeroFill(num:String, n:Int): String {
    var number = num
    if(num.length < n) {
        for (i in 0 until n-num.length) {
            number = "0"+number
        }
    }
    return number
}





