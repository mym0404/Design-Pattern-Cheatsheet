package creational.abstractfactory

import creational.abstractfactory.android.AndroidScrollBar
import creational.abstractfactory.android.AndroidWindow

fun abstractFactory() {
    WidgetFactory.register("ScrollBar", AndroidScrollBar())
    WidgetFactory.register("Window", AndroidWindow())

    WidgetFactory.create<ScrollBar>("ScrollBar").scrollTo(5)
    WidgetFactory.create<Window>("Window").resize(100, 200)
}