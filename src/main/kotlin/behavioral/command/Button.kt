package behavioral.command

class Button {
    var onClickListener: (() -> Unit)? = null
    fun click() = onClickListener?.invoke()
}