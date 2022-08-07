package creational.prototype

fun prototype() {
    GraphicTool(Text("123")).run {
        manipulate()
    }
    GraphicTool(MusicalNote()).run {
        manipulate()
    }
}