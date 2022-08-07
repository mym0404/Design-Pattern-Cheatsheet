package creational.abstractfactory.android

import creational.abstractfactory.ScrollBar
import creational.abstractfactory.Window

class AndroidScrollBar : ScrollBar {
    override fun clone() = AndroidScrollBar()

    override fun scrollTo(offset: Int) {
        println("Android scrollTo $offset")
    }
}

class AndroidWindow : Window {
    override fun clone() = AndroidWindow()

    override fun resize(width: Int, height: Int) {
        println("Android resize $width x $height")
    }
}