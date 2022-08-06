import behavioral.command.Button
import behavioral.command.DocumentOpener
import behavioral.command.OpenDocumentCommand

fun main() {
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