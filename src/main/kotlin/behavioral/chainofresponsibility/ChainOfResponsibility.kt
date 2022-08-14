package behavioral.chainofresponsibility

interface HelpHandler {
    val successor: HelpHandler?
    fun requestHelpText(): String {
        return successor?.requestHelpText() ?: "No help text"
    }
}

interface Widget : HelpHandler {
    val parent: Widget?
    override val successor: HelpHandler?
        get() = parent
    val children: List<Widget>
    fun addChild(widget: Widget)
}

class Application(private val helpText: String) : Widget {
    override val parent: Widget? = null
    override val children = mutableListOf<Widget>()

    override fun addChild(widget: Widget) {
        children.add(widget)
    }

    override fun requestHelpText(): String {
        return helpText
    }
}

class Dialog(override val parent: Widget) : Widget {
    override val children = mutableListOf<Widget>()

    override fun addChild(widget: Widget) {
        children.add(widget)
    }
}

class Button(override val parent: Widget) : Widget {
    override val children = listOf<Widget>()

    override fun addChild(widget: Widget) {
        TODO("Not yet implemented")
    }
}

