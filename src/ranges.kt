
fun main(args: Array<String>) {
    for (i in 1..4) {
        print(i)
    }

    // print nothing
    for (i in 4..1) {
        print(i)
    }

    for (i in 4 downTo 1) {
        print(i)
    }

    for (i in 1..4 step 2) {
        print(i)
    }

    for (i in 4 downTo 1 step 2) print(i)

    assert((1..12 step 2).last == 11)
    assert((1..12 step 2).first == 1)

}