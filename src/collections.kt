

fun main(args: Array<String>) {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    println(numbers)
    // a read-only reference to numbers
    val readOnlyView: List<Int> = numbers;

    numbers.add(4)
    println(readOnlyView)

    // you can't modify readonly view
    //    readOnlyView.clear()

    var strings = hashSetOf("a", "a", "b", "c")
    assert(strings.size == 3)

    class Controller {
        private val _items = mutableListOf<String>()
        // make a read-only reference
        val items: List<String> get() = _items.toList()
    }

    println(Controller().items)

    val items = listOf(1, 2, 3)
    assert(items.first() == 1)
    assert(items.last() == 3)

    println(items.filter { it.mod(2) == 0 })
    println(items.requireNoNulls())

    if (items.none { it > 6 }) {
        println("no number above 6")
    }

    var item = listOf<Int>().firstOrNull();
    println(item)

    var readWriteMap = hashMapOf("a" to 1, "b" to 2)
    readWriteMap["a"] = 2
    println(readWriteMap)

    // create a read-only reference to mutable hash map
    var snapshot: Map<String, Int> = readWriteMap;
    // read-only refercence can't be altered
    // snapshot["a"] = 3
}
