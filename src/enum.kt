enum class Direction {
    EAST, SOUTH, WEST, NORTH
}

// Since each enum is an instance of the enum class, they can be initialized
enum class Color(val rgb: Int) {
    RED(0xff0000),
    GREEN(0x00ff00),
    BLUE(0x0000ff)
}

// Enum constants can declare their own anonymous classes
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

fun main(args: Array<String>) {

    println(ProtocolState.values())
}