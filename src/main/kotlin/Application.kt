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
        val inputSub = input.substring(2).split("\\n")
        val syntax = "[,:" + inputSub[0] + "]"
        numString = inputSub[1].split(syntax.toRegex())
        println(numString)
    } else {
        numString = input.split("[,:]".toRegex())
        println(numString)
    }
    if (!numString.isEmpty())
        output = changeInt(numString).sum()

    println("결과: " + output)
}

fun changeInt(numStr: List<String>): MutableList<Int> {
    val numInt = mutableListOf<Int>()
    for (num in numStr) {
        numInt.add(num.toInt())
    }
    return numInt
}