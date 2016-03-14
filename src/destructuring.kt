/**
 *
 * Created by xc on 16-3-14.
 */

data class Result(val result: Int, val status: String)

fun main(args: Array<String>) {
    // destructoring components
    val (result, status) = Result(1, "start")
    println("${result}: ${status}")


    // same as
    //    with(Result(1, "start")) {
    //        val result = component1()
    //        var status = component2()
    //    }


    // destructoring from list
    for ((result, status) in listOf(Result(1, "start"), Result(2, "end"))) {
        println("${result}: ${status}")
    }

    // destructoring from map
    for ((name, age) in mapOf("name" to "xiechao", "age" to 34)) {
        println("${name}: ${age}");
    }
}