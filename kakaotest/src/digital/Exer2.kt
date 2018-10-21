package digital

import java.util.*


fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val m = input.nextLine().replace(" ", "").toInt()
    val Ni = mutableListOf<Int>()

    val line = input.nextLine().trim().split(" ")
    for (i in 0 until m) {
        Ni.add(i, line[i].toInt())
    }

    val defNumber = mutableListOf<Int>()
    val line2 = input.nextLine().trim().split(" ")
    for (i in 0 until m) {
        defNumber.add(i, line2[i].toInt())
    }

    val count = input.nextInt()

    println("m은 $m 최대값은 $Ni 초기값은 $defNumber 카운트는 $count")

    var result = ((count+defNumber[m-1]) % (Ni[m-1]+1)).toString()
    result = (((count+defNumber[m-1]) / (Ni[m-1]+1)) + defNumber[0]).toString() + result

    println("중간 계산 결과 $result")
}

