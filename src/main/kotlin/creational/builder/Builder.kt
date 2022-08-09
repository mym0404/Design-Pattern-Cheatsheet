package creational.builder

data class Computer(
    val ram: Int = 0,
    val disk: Int = 0,
)

interface ComputerBuilder {
    fun ram(gb: Int): ComputerBuilder
    fun disk(gb: Int): ComputerBuilder
    fun build(): Computer
}

class StandardComputerBuilder(private val computer: Computer = Computer()) : ComputerBuilder {
    override fun ram(gb: Int): ComputerBuilder {
        return StandardComputerBuilder(computer.copy(ram = gb))
    }

    override fun disk(gb: Int): ComputerBuilder {
        return StandardComputerBuilder(computer.copy(disk = gb))
    }

    override fun build(): Computer {
        return computer
    }
}
