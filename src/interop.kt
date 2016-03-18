import a_java_lib.A

fun test(a: A) {
    println(a.f(10))
}

fun main(args: Array<String>) {

    test(object : A {
        override fun f(x: Int): Int {
            return x * 2
        }
    })

    test(A {
        x -> x * 3
    })

}