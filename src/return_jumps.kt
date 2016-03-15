import kotlin.jvm.internal.iterator

operator fun String.times(n: Int): String {
    var sb = StringBuilder();

    for (i in 0..n) {
        sb.append(this);
    }
    return sb.toString();
}

fun manifest(s: String) {
    println("*" * 16)
    println(s + "...")
}

fun main(args: Array<String>) {

    manifest("BREAK LOOPS")
    for (i in 1..10) {
        println(i)
        for (j in 1..20) {
            if (j == 10) {
                break // it only breaks at inner loop
            }
        }
    }

    loop@ for (i in 1..10) {
        println(i)
        for (j in 1..20) {
            if (j == 10) {
                break@loop // break at outter loop
            }
        }

    }

    manifest("RETURNS from FUNCTIONS")
    fun printIntsButZero(ints: List<Int>) {
        ints.forEach {
            if (it == 0) {
                return // lambda expression returns from enclosing function
            }
            println(it)
        }
    }

    printIntsButZero(listOf(0, 1, 2, 3))

    fun printIntsButZero1(ints: List<Int>) {
        ints.forEach lambda@ {
            if (it == 0) {
                return@lambda // lambda expression returns from enclosing function
            }
            println(it)
        }
    }
    printIntsButZero1(listOf(0, 1, 2, 3))

    // best way to prevent returns from enclosing function
    fun printIntsButZero2(ints: List<Int>) {
        ints.forEach {
            if (it == 0) {
                return@forEach // lambda expression returns from enclosing function
            }
            println(it)
        }
    }
    printIntsButZero2(listOf(0, 1, 2, 3))

    // or just use anonymous function
    fun printIntsButZero3(ints: List<Int>) {
        ints.forEach(fun(i: Int) {
            if (i == 0) {
                return
            }
            println(i)
        })
    }
    printIntsButZero3(listOf(0, 1, 2, 3))

}
