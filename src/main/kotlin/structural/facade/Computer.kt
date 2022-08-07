package structural.facade

// Facade
class Computer {
    private val cpu = CPU()
    private val hardDrive = HardDrive()
    private val memory = Memory()
    fun start() {
        cpu.freeze()
        val bootAddress = 0x15151515
        memory.load(bootAddress, hardDrive.read())
        cpu.jump(bootAddress)
        cpu.execute()
    }
}

internal class CPU {
    fun freeze() {
        println("freeze CPU")
    }

    fun jump(position: Int) {
        println("jump instruction to $position")
    }

    fun execute() {
        println("execute")
    }
}

internal class HardDrive {
    fun read(): String {
        return "Read string from Hard Drive"
    }
}

internal class Memory {
    fun load(position: Int, data: String) {
        println("Data($data) is loaded on memory at $position")
    }
}