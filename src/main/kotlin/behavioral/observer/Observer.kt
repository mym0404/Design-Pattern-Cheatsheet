package behavioral.observer

abstract class Subject<T>(private val observerMediator: ObserverMediator<T>, initialValue: T) {
    var value = initialValue
        set(value) {
            field = value
            observerMediator.run {
                this@Subject.update(value)
            }
        }

    fun attach(observer: Observer<T>) {
        observerMediator.run {
            this@Subject.register(observer)
        }
    }

    fun detach(observer: Observer<T>) {
        observerMediator.run {
            this@Subject.unregister(observer)
        }
    }

    fun detachAll() {
        observerMediator.run {
            this@Subject.unregisterAll()
        }
    }
}

class IntegerSubject(observerMediator: ObserverMediator<Int>, initialValue: Int) :
    Subject<Int>(observerMediator, initialValue)

interface Observer<T> {
    fun update(value: T)
}

class IntegerObserver(value: Int) : Observer<Int> {
    var value = value
        private set

    override fun update(value: Int) {
        this.value = value
    }
}

abstract class ObserverMediator<T> {
    abstract fun Subject<T>.register(observer: Observer<T>)

    abstract fun Subject<T>.unregister(observer: Observer<T>)

    abstract fun Subject<T>.unregisterAll()

    abstract fun Subject<T>.update(value: T)
}

class SimpleHashMapEvenIntegerObserverMediator : ObserverMediator<Int>() {
    private val mapper = hashMapOf<Subject<Int>, MutableList<Observer<Int>>>()
    override fun Subject<Int>.register(observer: Observer<Int>) {
        mapper.getOrPut(this) { mutableListOf() }.add(observer)
    }

    override fun Subject<Int>.unregister(observer: Observer<Int>) {
        mapper[this]?.run {
            remove(observer)
            if (isEmpty()) mapper.remove(this@unregister)
        }
    }

    override fun Subject<Int>.unregisterAll() {
        mapper.remove(this)
    }

    override fun Subject<Int>.update(value: Int) {
        if (value % 2 == 0) {
            mapper[this]?.forEach { it.update(value) }
        }
    }
}