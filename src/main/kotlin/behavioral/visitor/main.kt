package behavioral.visitor

fun visitor() {
    val mainBoard = MainBoard()
    val mainBoard2 = MainBoard()
    val mainBoard3 = MainBoard()
    val floppyDisk = FloppyDisk()

    mainBoard.add(mainBoard2)
    mainBoard2.add(mainBoard3)
    mainBoard3.add(floppyDisk)

    val visitor: ComputerPartVisitor = DoublePricePrinterVisitor()
    mainBoard.accept(visitor)
}