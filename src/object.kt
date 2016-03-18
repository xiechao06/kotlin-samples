package barasdfasdf

open class A(val x: Int) {
    public open val y = x
}

interface B

// C is a singleton
object C {
    val value = 1
}

class MyClass {
    companion object {
        fun create(): MyClass = MyClass()
    }
}

interface Factory<T> {
    fun create(): T
}

class MyClass1 {
    // companion object could extend other interfaces
    companion object: Factory<MyClass1> {
        override fun create(): MyClass1 = MyClass1()
    }
}

interface X {
    fun x(v: Int): Int
}

fun f(x: X) {
    println(x.x(10))
}

fun main(args: Array<String>) {
    // an object expression just works like anonymous inner classes
    var obj = object : A(1), B {
        override val y = 15
    }
    println(obj)

    f(object : X {
        override fun x(v: Int): Int {
            return v * 2;
        }

    })

    // or just an object inherited from Any
    var adHoc = object {
        var x = 0
        var y = 0
    }

    println(adHoc)

    // access the singleton of type C
    println(C.value)

    // companion object's methods could be accessed directly
    MyClass.create()
}
