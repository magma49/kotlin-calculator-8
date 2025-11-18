package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine().trim()

    var output = 0

    var numString = emptyList<String>()

    if (input.isEmpty()) {
        output = 0
    } else if (input.take(2) == "//") {
        output = 1
    } else {
        numString = input.split("[,:]".toRegex())
        println(numString)
        output = 2
    }
    println("결과: " + output)
}