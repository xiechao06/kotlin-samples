package foo

// any top level declarations are open by default
fun foo() {}

private fun bar() {} // only visible in this file

var bar = 5
    private set // only visible in this file

internal val x = 6 // visible in module

class A {
    private val a = 1 // only visible in class A
    protected val b = 1 // visible in this class and subclasses
    internal val c = 1 // visible in this module
}

fun main(args: Array<String>) {
    bar = 2

    println(A().c)
}