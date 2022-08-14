package behavioral.iterator

interface Traversable<T> {
    val iterator: Iterator<T>
}

interface MyCollection<T>: Traversable<T> {
    val count: Int
    fun get(i: Int): T
}

interface Iterator<T> {
    val isDone: Boolean
    fun begin()
    fun next(): T
}

class MyList<T>(private val list: List<T>) : MyCollection<T> {
    override val iterator: Iterator<T>
        get() = ListIterator(this)
    override val count: Int
        get() = list.size

    override fun get(i: Int) = list[i]
}

class ListIterator<T>(private val list: MyList<T>) : Iterator<T> {
    private var cur = 0
    override val isDone: Boolean
        get() = cur >= list.count

    override fun begin() {
        cur = 0
    }

    override fun next(): T {
        cur++
        return list.get(cur - 1)
    }
}