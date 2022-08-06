package structural.composite

// Component
abstract class ComputerPart {
    open val name: String get() = this::class.java.simpleName
    abstract val price: Int
    var parent: ComputerPart? = null
}

// Composite
abstract class ComputerPartGroup : ComputerPart() {
    private val children = mutableListOf<ComputerPart>()
    fun add(equipment: ComputerPart) {
        assert(equipment.parent == null && equipment !in children)
        children.add(equipment.also {
            it.parent = this
        })
    }

    fun remove(equipment: ComputerPart) {
        assert(equipment.parent == this && equipment in children)
        children.remove(equipment.also {
            it.parent = null
        })
    }

    override val price: Int
        get() = children.sumOf { it.price }
}

// Composite #1
class MainBoard : ComputerPartGroup()

// Leaf #1
class FloppyDisk : ComputerPart() {
    override val price: Int
        get() = 5000
}