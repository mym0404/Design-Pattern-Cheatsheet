package structural.proxy

fun proxy() {
    val image: Graphic = ImageProxy(ImageMetaData(100, 100, "path"))
    image.draw()
}