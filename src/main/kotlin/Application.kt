package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    val input: String = Console.readLine().trim()

    var output = 0

    var numString: List<String> = emptyList()

    if (input.isEmpty()) {
        output = 0
    } else if (input.take(2) == "//") {
        val inputSub: List<String> = input.substring(2).split("\\n")
        val syntax: String = "[,:" + inputSub[0] + "]"
        numString = inputSub[1].split(syntax.toRegex())
    } else {
        numString = input.split("[,:]".toRegex())
    }
    if (!numString.isEmpty())
        output = sumNum(numString)

    println("결과: $output")
}

fun sumNum(numString: List<String>): Int {
    var sum = 0
    for (numStr in numString) {
        var num: Int
        val numS = numStr.trim()
        if (numS == "") continue
        try {
            num = numS.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력해주세요.")
        }
        require(num >= 0) { "[ERROR] 0이상의 정수만 입력해주세요." }
        sum += num
    }
    return sum
}