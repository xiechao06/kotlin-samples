// Interface is "open" by default

interface MyInterface {
    // interface's methods is "open" by default
    fun foo()
    // interface can't hold "STATE", but method could have definition
    fun bar() {
        println("bar")
    }

    // abstract property, must be overrided
    val p: Int

    // a property with getter, note that doesn't require a backing field
    val x: Int
        get() = 1
}

class Child: MyInterface {
    override val p: Int
        get() = 1

    override fun foo() {
        println("child's foo")
    }
}

fun main(args: Array<String>) {
    val c = Child()
    c.foo()
    c.bar()
}
