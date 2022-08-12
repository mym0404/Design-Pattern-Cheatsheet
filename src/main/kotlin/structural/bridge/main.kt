package structural.bridge

fun bridge() {
    val window: Window = DialogWindow { AppWindowImpl() }
    window.drawContent()
}
