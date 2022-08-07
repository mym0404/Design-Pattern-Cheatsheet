package structural.decorator

interface VisualComponent {
    fun draw()
}

interface Decorator : VisualComponent {
    val component: VisualComponent
    override fun draw() {
        component.draw()
    }
}

class TextView : VisualComponent {
    override fun draw() {
        println("Draw text")
    }
}

class BorderDecorator(override val component: VisualComponent) : Decorator {
    override fun draw() {
        super.draw()
        drawBorder()
    }

    private fun drawBorder() {
        println("Draw border")
    }
}

class DropShadowDecorator(override val component: VisualComponent) : Decorator {
    override fun draw() {
        super.draw()
        drawDropShadow()
    }

    private fun drawDropShadow() {
        println("Draw drop shadow")
    }
}

