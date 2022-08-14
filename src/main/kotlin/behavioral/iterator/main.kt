package behavioral.iterator

fun iterator() {
    val original = listOf(1, 2, 3)
    val list = MyList(original)

    val it = list.iterator
    while (!it.isDone) println(it.next())

    original.iterator()
}