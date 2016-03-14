import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

var x = 1

val String.lastChar: Char
    get() = this[length - 1]


fun main(args: Array<String>) {

    class MyClass

    val c = MyClass::class

    println(c)
    println(c.java)

    fun odd(x: Int) = x % 2 != 0

    println(listOf(1, 2, 3).filter(::odd))

    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = { x -> f(g(x)) }

    fun length(s: String) = s.length

    var oddLength = compose(::odd, ::length)
    println(listOf("a", "ab", "abc").filter(oddLength))


    // :: to access property
    // access top level objects
    println(::x.get())
    ::x.set(2)
    println(::x.get())

    // access properties
    println(listOf("a", "ab").map(String::length))

    class A(val p: Int)
    println(A::p.get(A(1)))

    println(String::lastChar.get("abc"))

    println(A::p.javaGetter)
    println(A::p.javaField)

    class Foo

    fun makeFoo(factory: () -> Foo): Foo = factory()

    // access to constructor
    println(makeFoo(::Foo))
}