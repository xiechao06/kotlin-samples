package extensions

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

// properties could be extended either
val <T> MutableList<T>.lastIndex: Int
    get() = size - 1

class MyClass {
    companion object {}
}

// define extension with companion object
fun MyClass.Companion.foo() {
    println("foo")
}

class A {
    fun bar() {
        println("bar")
    }
}


class B {
    fun baz() {
        println("baz")
    }

    fun A.foo() {
        bar() // receiver is A
        baz() // receiver is (B)dispatcher
    }

    fun bar() {
        println("B's bar")
    }

    fun A.baz() {
        bar() // receiver is A
        this@B.bar() // receiver is (B)dispatcher
    }

    fun caller(a: A) {
        a.foo() // extension defined in this class
    }
}

open class D
class D1: D()

open class C {
    open fun D.foo() {
        println("D's foo in C")
    }

    open fun D1.foo() {
        println("D1's foo in C")
    }

    fun caller(d: D) {
        d.foo()
    }
}

open class C1: C() {
    // extensition function worked as methods of dispatcher, and determined by extension receiver's type (statically)
    override fun D.foo() {
        println("D's foo in C1")
    }

    override open fun D1.foo() {
        println("D1's foo in C")
    }

}

fun main(args: Array<String>) {
    var l = mutableListOf(1, 2, 3)
    l.swap(1, 2)

    println(l)

    open class E

    class F : E()

    fun E.foo() = "c"
    fun F.foo() = "d"

    fun printFoo(e: E) {
        println(e.foo())
    }

    // extension method is not member function, it is dispatched statically, so it is determined
    // by signature, you could just consider it as a utility function
    printFoo(F())

    class G {
        fun foo() = "member"
    }

    fun G.foo() = "extension"

    // member function always win
    println(G().foo())

    // extension could be defined with nullable receiver
    fun Any?.toString(): String {
        if (this == null) {
            return "null"
        }
        return toString()
    }

    println(null.toString())

    MyClass.foo()

    B().caller(A())

    C().caller(D())
    C().caller(D1())

    C1().caller(D())
    C1().caller(D1())

}