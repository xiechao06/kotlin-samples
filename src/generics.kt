package generics

import java.util.*

class Box<T>(t: T) {
    val value = t
}

// producer out
// obviously, Source doesn't consume T, it is valid to be covariant in parameter T,
// that means, Source<Int> is subclass of Source<Any>(Source<? extends Int> in java), or it produces T
// "out" tells compiler that if A is subclass of B, then Source<A> is subclass of Source<B>
class Source<out T>

// Consumer in
// "in" tells compiler that if A is superclass of B, then Source<B> is subclass of Source<A>
interface MyComparable<in T> {
    // compareTo consumes T, it is valid to be contravariant in parameter T,
    // that means, Comparable<Any> is subclass of Comparable<Int>(Comparable<? super T> in java) (whilst Int is subclass of Any, that
    // is why it is called contravariant)
    // why? let us examine this example:
    // val cn: Comparable<Number> = ...
    // val ci: Comparable<Int> = cn
    // ci.compareTo(1)
    // ci.compareTo takes Int as "other", however cn.compareTo is actually invoked,
    // and cn could compare to Int (since Int is subtype of Number)
    // but vice versa it won't works, since ci can't compare with Number
    fun compareTo(other: T): Int
}

fun demo(x: MyComparable<Number>) {
    x.compareTo(1.0)
    val y: MyComparable<Double> = x
    val z: MyComparable<Int> = x
}

// Type Array is both producer/consumer of type Any
// however, we can assure that "from" acts as producer, and consumer acts as consumer
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

// to is consumer of type String
fun fill(to: Array<in String>, value: String) {
    for (i in to.indices) {
        to[i] = value
    }
}

// generic function
fun <T> foo(item: T): List<T> {
    return listOf();
}

// generic extension function
fun <T> T.basicToString(): String {
    return ""
}

// only subtypes of Comparable<T> (which is upper bound of T) could be sorted
fun <T : Comparable<T>> sort(list: List<T>) {
    // ...
}

// only subtypes of both Comparable<T> and Cloneable accepted
fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
    where T : Comparable<T>, T : Cloneable {
    return list.filter { it > threshold }
}

fun main(args: Array<String>) {
    val b = Box(1)
    println(b.value)
    val ts: Source<Any> = Source<String>()
    val to: Array<Any> = Array(3, { "" })
    val from: Array<Int> = arrayOf(1, 2, 3)

    copy(from, to)

    fill(Array<CharSequence>(3, {""}), "wawa")
}