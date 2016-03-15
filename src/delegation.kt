package delegations

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

// just delegate the method need to be implemented to b
class Derived(val b: Base) : Base by b

// a property delegates must implement operators getValue/setValue
class Delegate {
    operator fun getValue(ref: Any?, property: KProperty<*>): String {
        return "$ref, thank you for delegating '${property.name}' to me!"
    }
    operator fun setValue(ref: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $ref.'")
    }
}


class Example {
    // property p is delegated
    var p: String by Delegate()
}

// this value is lazy evaluated
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}


// observe the set action
var observableValue: String by Delegates.observable("<no value>") {
    prop, old, new ->
    println("$old -> $new")
}

// properties delegate to a map
class User(map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}

fun main(args: Array<String>) {
    Derived(BaseImpl(5)).print()

    val e = Example()
    e.p = "abc"
    println(e.p)

    println(lazyValue)
    println(lazyValue)

    println(observableValue)
    observableValue = "a"
    observableValue = "b"

    val u = User(mutableMapOf(
            "name" to "abc",
            "age" to 12
    ))
    println(u.name)
    u.name = "bcd"
    println(u.name)
}