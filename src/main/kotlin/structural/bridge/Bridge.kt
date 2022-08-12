package structural.bridge

// Abstraction
abstract class Window(windowImplCreator: () -> WindowImpl) {
    private val impl by lazy(windowImplCreator)
    fun drawText() {
        impl.drawText()
    }

    fun drawRect() {
        impl.drawRect()
    }

    abstract fun drawContent()
}

// RefinedAbstraction
class DialogWindow(windowImplCreator: () -> WindowImpl) : Window(windowImplCreator) {
    override fun drawContent() {
        println("----DIALOG----")
        drawRect()
        drawText()
        drawText()
        println("--END DIALOG--")
    }
}

// Implementor
interface WindowImpl {
    fun drawText()
    fun drawRect()
}

// ConcreteImplementor
class AppWindowImpl : WindowImpl {
    override fun drawText() {
        println("draw app text")
    }

    override fun drawRect() {
        println("draw app rect")
    }
}

