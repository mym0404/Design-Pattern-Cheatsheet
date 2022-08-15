package behavioral.mediator

// Colleague
abstract class Widget {
    abstract val director: DialogDirector
    fun onChanged() = director.onWidgetChanged(this)
}

class Button(override val director: DialogDirector) : Widget() {
    var isEnabled = false
    fun press() {
        onChanged()
    }
}

class Text(override val director: DialogDirector) : Widget() {
    var text = ""
        set(value) {
            field = value
            onChanged()
        }
}

// Mediator
abstract class DialogDirector {
    abstract fun onWidgetChanged(widget: Widget)
    abstract fun printWidgetStatus()
}

class FontDialogDirector : DialogDirector() {
    val text1 by lazy { Text(this) }
    val text2 by lazy { Text(this) }
    val btn by lazy { Button(this) }
    override fun onWidgetChanged(widget: Widget) {
        when (widget) {
            text1 -> {
                if (text2.text != text1.text) text2.text = text1.text
                btn.isEnabled = text1.text.isNotBlank()
            }
            text2 -> {
                if (text1.text != text2.text) text1.text = text2.text
                btn.isEnabled = text2.text.isNotBlank()
            }
            btn -> {
                text1.text = ""
            }
        }
    }

    override fun printWidgetStatus() {
        println("Dialog ${text1.text} ${text2.text} ${btn.isEnabled}")
    }
}