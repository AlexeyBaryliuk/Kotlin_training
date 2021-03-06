package com.my

class PlainShort{}

class ShortClass

class WithConstructor constructor(name: String, age: Int)

class WithoutConstructor(name: String, age: Int)

class MandatoryConstructor internal constructor(name: String, age: Int){}

class CurseProperty(courseTitle: String){
    val title = courseTitle
}

class PersonClass(name: String, age: Int){}


fun main(){
    val course = Course("course")
    val courseWithConstructor = Course("courseWithConstr", "Place")
    course.description = "escription"
    println(course.show())
    println(course)

    course.description = ""
    course.someStr = ""

    println(course)
    println(courseWithConstructor)
}
class Course(courseTitle: String = "SomeTitle"){
    private val title = courseTitle
    private var place = ""
    internal var description = ""
        get(){
            return if (field.isNullOrBlank()) "no description " else "$field"
        }
    var someStr = "someString"
    get(){
        return if (field.isNullOrBlank()) "no description " else "$field"
    }

    fun show() = "Title is $title"

    override fun toString(): String {
        return "($title) and ($description) and ($someStr)"
    }

    init {
        println( "Hello from init ${show()}")
    }

    // constructors

    constructor(title: String, place:String): this(title){
        this.place = place
    }
}
