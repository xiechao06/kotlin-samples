package data_classes

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {
    val p = Person("abc", 32)
    var p1 = p.copy(age=19)
    println(p1)

    // data class could be destructed
    val (name, age) = p
    println("$name - $age")
}