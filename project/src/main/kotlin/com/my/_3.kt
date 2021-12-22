package com.my

fun returnNothing() = "Return nothing text"

fun main() {
    first()
    println(secondIfExpr(1))
    third()
    forthLoop()
    nullsSmart()

}

fun first(){
    val bigger = 1000
    val smaller = 1
    val max = if (bigger > smaller) "true" else "false"

    println(max)

    val age = 35
    val boardGroup = when (age) {
        in 0..18 -> "family"
        in 65..200 -> "senior"
        else -> "regular"
    }
    println("Ypu are $boardGroup group" )

    val fromNothing = returnNothing()
    println("$fromNothing")
}

fun secondIfExpr(test: Int): String {
    val number: Any = if(test > 10) {
       "alpha"
    } else if (test < 10) {
        println("$test less then 10")
        1
    } else {
        println("$test is equals 10")
        2
    }
    return number.toString()
}
fun third(){

    val x = 1
    when(x){
        1 -> println("x == 1")
        2 -> println("x == 2")
        3,4 -> println("x == 3 or 4")
    }

    val card = Suit.Club
    when(card) {
        Suit.Diamond, Suit.Club -> println(" dim or club")
        Suit.Heart -> println("${Suit.Heart}")
    }

    val test = "test1"
    val res = when(test) {
        "test1" -> "1"
        "test2" -> "2"
        else -> {
            "Unknown"
        }
    }

    println("Result int = $res")

    val testInt = 55
    val resInt = when(testInt) {
        in 1..10 -> "1"
        in 40..60 -> "2"
        else -> "Unknown"
    }
    println("Result int = $resInt")
}

fun forthLoop(){
    for (i in 1..10){
        println("i = $i")
    }

    val numbers = listOf("1", "2", "3", "4")

     for (number in numbers)
         println("Number = $number")

    for ((index, number) in numbers.withIndex()){
        println("Index = $index . number = $number")
        println("Index = ${index + 1} . number = ${number.toLong() + 2L} long")
    }
}

fun nullsSmart(){
    val person1: Person? = null

    val greeting: String? = null
    if (greeting != null){
        println("Greeting is not null")
    } else {
        println("IS NULL")
    }

    println("Greeting  = ${greeting?.length}")

    val len = greeting?.length ?: 0
    println("Len = $len ")

// NullPointerException
//    var len1 = greeting!!.length

//    val safeGreetings: String? = greeting as? String
}
enum class Suit {
    Club, Diamond, Heart
}

