package behavioral.chainofresponsibility

fun chainOfResponsibility() {
    val app = Application("My Application")
    val dialog = Dialog(app)
    app.addChild(dialog)

    val button = Button(dialog)
    dialog.addChild(button)

    println(button.requestHelpText()) // My Application
}