

class Outer {
    private val bar: Int = 1

    // inner class is static by default
    class Inner {
        fun foo() = 2
    }

    // unless you add inner modifier
    inner class Inner1 {
        fun foo() {
            println(bar)
        }
    }
}

fun main(args: Array<String>) {
    Outer.Inner().foo()
}