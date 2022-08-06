package behavioral.command

fun command() {
    val opener = DocumentOpener()
    val command = OpenDocumentCommand(opener)

    val invoker = Button().apply {
        onClickListener = {
            command.execute()
        }
    }

    invoker.click()

    invoker.onClickListener = null
}