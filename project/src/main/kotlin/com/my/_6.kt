package com.my

fun main() {

    val num = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
    val fnum = num.filter(fun(a: Int): Boolean { return a < 7 })
    println("Fnum = $fnum")

    val fnumL = num.filter(fun(a) = a < 7)
    println("FnumL = $fnumL")

    val getAge = lambda@{ a: Int ->
        if (a >= 65)
            return@lambda "senior discount"
        else if (a >= 21)
            return@lambda "regular"
        "undegraund"
    }

println("GetAge = ${getAge(80)}")


val getAgeF = fun(a: Int): String{

    if (a >= 65)
        return "senior discount"
    else if (a >= 21)
        return "regular"
    return "undegraund"
}

println("GetAge = ${getAgeF(19)}")
}