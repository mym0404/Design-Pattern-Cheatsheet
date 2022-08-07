package creational.abstractfactory.ios

import creational.abstractfactory.ScrollBar
import creational.abstractfactory.Window

class IOSScrollBar : ScrollBar {
    override fun clone() = IOSScrollBar()

    override fun scrollTo(offset: Int) {
        println("IOS scrollTo $offset")
    }
}

class IOSWindow : Window {
    override fun clone() = IOSWindow()

    override fun resize(width: Int, height: Int) {
        println("IOS resize $width x $height")
    }
}