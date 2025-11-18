package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine().trim()

    var output = 0

    if (input.isEmpty()) {
        output = 0
    } else if (input.take(2) == "//") {
        output = 1
    } else {
        output = 2
    }
    println("결과: " + output)
}