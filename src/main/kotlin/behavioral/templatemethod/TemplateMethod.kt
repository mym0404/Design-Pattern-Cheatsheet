package behavioral.templatemethod

abstract class View {
    fun display() {
        requestFocus()
        onBeforeDisplay()
        doDisplay()
        onAfterDisplay()
        blurFocus()
    }

    private fun requestFocus() {
        println("Request focus")
    }

    private fun blurFocus() {
        println("Blur focus")
    }

    protected abstract fun doDisplay()
    protected fun onBeforeDisplay() {}
    protected fun onAfterDisplay() {}
}

class Button : View() {
    override fun doDisplay() {
        println("Display Button")
    }
}