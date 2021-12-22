package com.my

fun main(){
    println("Hello")
    println(orOperator(false))
    strings()
}

private fun orOperator(value: Boolean) {
    println(" Hello $value")
}
fun strings(){
    val greeting: String = "Hello there"
    val owe = 50

    val infinity = "The infinity is \u221E"


    val s1 = "s1"
    val s2 = "s2"

    println(s1.compareTo(s2))


    for (char in greeting)
        print("$char ")

    val format = """
        my string 
        is formatted
            !
    """
    println(format)

}

