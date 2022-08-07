package structural.decorator

fun decorator() {
    val dropShadowBorderTextView: VisualComponent = DropShadowDecorator(BorderDecorator(TextView()))

    dropShadowBorderTextView.draw()
}