package creational.abstractfactory

interface Widget {
    fun clone(): Widget
}

object WidgetFactory {
    private val widgetRegistry = hashMapOf<String, Widget>()

    fun register(key: String, prototype: Widget) {
        widgetRegistry[key] = prototype
    }

    fun <T : Widget> create(key: String) = widgetRegistry[key]!!.clone() as T
}

interface ScrollBar : Widget {
    fun scrollTo(offset: Int)
}

interface Window : Widget {
    fun resize(width: Int, height: Int)
}