package creational.prototype

// prototype
interface Graphic {
    fun draw()
    fun clone(): Graphic
}

// concrete prototype
class Text(val string: String) : Graphic {
    override fun draw() {
        println("Draw Text $string")
    }

    override fun clone() = Text(string)
}

// concrete prototype
class MusicalNote : Graphic {
    override fun draw() {
        println("Draw Musical Note")
    }

    override fun clone() = MusicalNote()
}

interface Tool {
    fun manipulate()
}

// client
class GraphicTool(private val graphic: Graphic) : Tool {
    override fun manipulate() {
        graphic.clone().draw()
    }
}
