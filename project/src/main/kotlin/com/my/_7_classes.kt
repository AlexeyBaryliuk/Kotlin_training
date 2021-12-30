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
    course.description = "description"
    course.show()
    println(course)

    course.description = ""
    course.someStr = ""

    println(course)
}
class Course(courseTitle: String){
    private val title = courseTitle
    internal var description = ""
        get(){
            return if (field.isNullOrBlank()) "no description " else "$field"
        }
    var someStr = "someString"
    get(){
        return if (field.isNullOrBlank()) "no description " else "$field"
    }

    fun show(){
        println("Title is $title")
    }

    override fun toString(): String {
        return "($title) and ($description) and ($someStr)"
    }
}
