package creational.factorymethod

// Creator
interface Application {
    fun createDocument(): Document

    fun openDocument() {
        val doc = createDocument()
        doc.open()
    }
}

class StandardApplication<T : Document> constructor(private val creator: () -> T) : Application {
    override fun createDocument(): T {
        return creator()
    }
}

// Product
interface Document {
    fun open()
}

// ConcreteProduct
class WebDocument : Document {
    override fun open() {
        println("Open Web document")
    }
}

class MobileDocument : Document {
    override fun open() {
        println("Open Mobile document")
    }
}
