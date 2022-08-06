package behavioral.command

class OpenDocumentCommand(private val documentOpener: DocumentOpener) : Command {
    override fun execute() {
        val path = askPath()
        documentOpener.action(path)
    }

    private fun askPath(): String {
        return readLine()!!
    }
}