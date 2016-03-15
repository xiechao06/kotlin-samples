
class Address {

    // declare a property with default getter/setter, note it is "var"
    var size = 0
    // declare a property with default getter, note it is "val"
    val readOnly = 1

    val empty: Boolean
        get() = size == 0
    var x: Int
        get() = 1
        set(v) {
            println("x is set with $v")
        }

    // make setter private
    var privateSetter: Int = 1
        private set

    var boom = 0
        set(value) {
            if (value > 0) {
                // "field" actually stores the boom property, it will only created when setter
                // visits it
                field = value * 2
            }
        }

    // y will be initialized later
    lateinit var y: Foo

    fun setup() {
        y = Foo()
    }
}

class Foo

const val A = 1

fun main(args: Array<String>) {

    var a = Address()
    a.size = 2
    println(a.empty)

    a.x = 1
    a.boom = 2
    println(a.boom)

    a.setup()
    println(a.y)
}