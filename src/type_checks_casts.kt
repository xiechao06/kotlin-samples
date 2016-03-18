
fun main(args: Array<String>) {
    if ("abc" is String) {
        println("is string")
    }

    fun demo(x: Any) {
        // assure that x is String
        if (x !is String) return
        // the compiler is smart enough to know that x is String now!! So it compiles, this is called "SMART CASTS"
        println(x.length)
        if (x is String && x.length > 0) {
            // the compiler knows that x is String!!!, so it compiles
            print(x.length)
        }
    }
    demo("abc")

    fun badCast(x: Any?) {
        // null can't be cast to String, so operator "as" throws an exception
        val y: String = x as String;
        println(y);
    }

    fun safeCast(x: Any?) {
        // both x, y may be null, "as?" will make x be "null" is x is null
        val y: String? = x as? String;
        println(y);
    }

    safeCast(null);
    badCast(null);
}