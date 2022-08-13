package structural.proxy

interface Graphic {
    fun getSize(): Pair<Int, Int>
    fun draw()
}

class ImageProxy(private val imageMetaData: ImageMetaData) : Graphic {
    private var isLoaded = false
    private lateinit var image: Image
    override fun getSize(): Pair<Int, Int> {
        return imageMetaData.width to imageMetaData.height
    }

    override fun draw() {
        if (!isLoaded) {
            image = Image(imageMetaData)
        }
        image.draw()
    }
}

data class ImageMetaData(val width: Int, val height: Int, val path: String)
class Image(private val metaData: ImageMetaData) : Graphic {
    override fun getSize(): Pair<Int, Int> {
        return metaData.width to metaData.height
    }

    override fun draw() {
        println("Draw image")
    }
}