package structural.adapter

data class Rect(val top: Int, val right: Int, val bottom: Int, val left: Int)

interface Shape {
    fun getRect(): Rect
    fun createManipulator()
}

open class TextView {
    // (x, y)
    fun getOrigin(): Pair<Int, Int> {
        return 1 to 5
    }

    // width x height
    fun getSize(): Pair<Int, Int> {
        return 100 to 200
    }
}


class TextShape(private val textView: TextView) : Shape {
    override fun getRect(): Rect {
        val (x, y) = textView.getOrigin()
        val (w, h) = textView.getSize()
        return Rect(y, x + w, y + h, x)
    }

    override fun createManipulator() {
        println("create Text Manipulator")
    }
}