package structural.composite

fun composite() {
    val mainBoard = MainBoard()
    val mainBoard2 = MainBoard()
    val mainBoard3 = MainBoard()
    val floppyDisk = FloppyDisk()

    mainBoard.add(mainBoard2)
    mainBoard2.add(mainBoard3)
    mainBoard3.add(floppyDisk)

    assert(mainBoard.price == floppyDisk.price)

    var p: ComputerPart? = floppyDisk.parent
    while (p?.parent != null) p = p.parent
    assert(p == mainBoard)
}