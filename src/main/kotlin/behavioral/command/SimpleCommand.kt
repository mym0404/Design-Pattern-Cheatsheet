package behavioral.command

class SimpleCommand<R : Receiver>(private val receiver: Receiver) : Command {
    override fun execute() {
        receiver.action()
    }
}