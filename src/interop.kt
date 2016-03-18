import a_java_lib.A
import a_java_lib.JavaArrayExample
import java.util.*
import java.util.concurrent.ThreadPoolExecutor

fun test(a: A) {
    println(a.f(10))
}

fun demo(source: List<Int>) {

    val list = ArrayList<Int>()

    for (item in source) {
        list.add(item)
    }

    for (i in 0..source.size-1) {
        list[i] = source[i]
    }

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


    demo(listOf(1, 2, 3))
    val calendar = Calendar.getInstance()
    if (calendar.firstDayOfWeek == Calendar.SUNDAY) {
        calendar.firstDayOfWeek = Calendar.MONDAY
    }

    JavaArrayExample().removeIndices(intArrayOf(1, 2, 3))

    val array = intArrayOf(1, 2, 3)
    for (i in array.indices) {
        array[i] *= 2
    }

    JavaArrayExample().removeIndices2(*intArrayOf(1, 2, 3))

    val runnable = Runnable { println("Runnable") }

}