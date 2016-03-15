
// constructor could be omitted
class Customer(name: String) {
    init {
        println("initialized with name ${name}")
    }
}

class Person(name: String) {
    // secondary constructor must delegate to primary constructor
    constructor(name: String, parent: Person) : this(name) {
    }
}

class DontCreateMe private constructor()

// all classes are final by default, so add open if a class is to be inherited
open class Base(p: Int)

class Derived(p: Int): Base(p)

open class View {
    constructor(a: Int) {

    }

    constructor(a: Int, b: Float) {

    }
}

class DerivedView : View {

    // delegate to base's secondary constructor
    constructor(a: Int) : super(a) {

    }

    constructor(a: Int, b: Float) : super(a, b) {

    }

}

open class Base1 {
    open fun f() {

    }

    fun g() {

    }
}

class Derived1 : Base1() {
    final override fun f() {

    }
}

open abstract class Base3 {
    open abstract fun f()
}

class Derived2 : Base3() {
    override fun f() {

    }
}

// sealed class represents a restricted class hierarchies
sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}

fun Expr.eval() : Double = when(this) {
    is Expr.Const -> this.number
    is Expr.Sum -> this.e1.eval() + this.e2.eval()
    Expr.NotANumber -> Double.NaN
}

fun main(args: Array<String>) {
    Customer("abc")

    Person("abc", Person("bcd"))


    println(Expr.Sum(Expr.Const(2.0), Expr.Sum(Expr.Const(1.0), Expr.Const(9.0))).eval());
}