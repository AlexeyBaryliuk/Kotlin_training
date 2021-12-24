package com.my


fun main() {
    calculate("145+(2+2)*3+2*(2+2)+2*2")
}

// 1+2+3
fun calculate(strIn: String): Int {
    val signs = mutableListOf<Char>()
    val values = mutableListOf<Int>()
    var firstMinusNumber = false
    val nums = arrayOf("")
    val str = arrayOf(strIn)

    var currentIndex = 0

    for ((index, char) in str[0].withIndex()) {

        when (char) {
            '-' -> if (index == currentIndex) {
                if (currentIndex == 0) firstMinusNumber = true else signs.add(char)
            }
            '+' -> if (index == currentIndex) {
                signs.add(char)
            }

            '(' -> {
                if (index == currentIndex) {
                    if (nums[0] != "") {
                        values.add(nums[0].toInt())
                        nums[0] = ""

                    }
                    val index = str[0].indexOf(")")
                    val sub = str[0].substring(currentIndex, index + 1)
                    val external = calculate(sub.removeSurrounding("(", ")"))
                    values.add(external)
                    currentIndex = index + 1
                }
            }
            ')' -> println("It is $char")
            '*' -> if (index == currentIndex){
                var currentValue = 0
                    println("* ======")
                        if (str[0][currentIndex + 1].isDigit()){
                            currentValue = str[0][currentIndex + 1].digitToInt()
                            currentIndex += 2
                        } else {
                            val indexT = str[0].indexOf(")", currentIndex)
                            val sub = str[0].substring(currentIndex + 1 , indexT + 1)
                            currentValue = calculate(sub.removeSurrounding("(", ")"))
                            currentIndex = indexT + 1
                        }

                values[values.size - 1] = values[values.size - 1] * currentValue


                }
            '/' -> println("/ ======")
            else -> {
                if (index == currentIndex) {
                    if ((currentIndex > 1 && str[0][currentIndex - 1].isDigit()) ||
                        (currentIndex < str[0].length - 1 && str[0][currentIndex + 1].isDigit())
                    ) {

                        nums[0] += char.toString();
                    } else if (nums[0] != "") {
                        values.add(nums[0].toInt())
                        nums[0] = ""
                        values.add(char.digitToInt())
                    } else values.add(char.digitToInt())
                }
            }

        }
        if (index == currentIndex){
            currentIndex++
        }
    }
    println("Values ____________________________________")
    values.forEach(::println)
    println("Signs ____________________________________")
    signs.forEach(::println)

    println("RESULT = ${compute(values, signs)}")
    println("String = $strIn")

    return compute(values, signs)
}

fun compute(values: List<Int>, signs: List<Char>): Int {
    val signsT = mutableListOf<Char>()
    signsT.addAll(signs)
    val valuesT = mutableListOf<Int>()
    valuesT.addAll(values)

    val index = 0
    for (sign in signs) { // 1 2 3
        when (sign) {
            '+' -> valuesT[index] += valuesT[index + 1]
            '-' -> valuesT[index] -= valuesT[index + 1]
        }
        valuesT.removeAt(index + 1)
    }
    return valuesT[index]
}