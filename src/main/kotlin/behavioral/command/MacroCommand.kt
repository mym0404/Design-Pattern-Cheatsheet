package behavioral.command

class MacroCommand : Command {
    private val commands = mutableListOf<Command>()
    override fun execute() {
        commands.forEach { it.execute() }
    }

    fun addCommand(command: Command) {
        commands.add(command)
    }

    fun removeCommand(command: Command) {
        commands.remove(command)
    }
}