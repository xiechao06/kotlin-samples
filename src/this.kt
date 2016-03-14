class A {
    inner class B {
        fun Int.foo() {

            var a = this@A
            println(a)

            var b = this@B
            println(b)

            var c = this
            println(c)
            var c1 = this@foo
            println(c1)

            // add a label to this extension function, and "this" will be funLit's receiver
            var funLit = a@ fun String.() {
                var d = this
                println(d)
            }

            // no label, funLit2 has no receiver, this is foo's receiver
            var funLit2 = {
                s: String ->
                var d = this
                println(d)
            }

            "abc".funLit();
            funLit2("abc")
        }

        fun x() {
            1.foo()
        }
    }
}

fun main(args: Array<String>) {
    A().B().x()
}
