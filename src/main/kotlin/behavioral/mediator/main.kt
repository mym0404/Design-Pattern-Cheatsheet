package behavioral.mediator

fun mediator() {
    val dialogDirector = FontDialogDirector()

    dialogDirector.printWidgetStatus()
    dialogDirector.text1.text = "123"
    dialogDirector.printWidgetStatus()
}