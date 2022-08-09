package creational.builder

fun builder() {
    val computer = StandardComputerBuilder().ram(5).disk(15).build()
    assert(computer.ram == 5 && computer.disk == 15)
}