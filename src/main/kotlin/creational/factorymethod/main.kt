package creational.factorymethod

fun factoryMethod() {
    val app: Application = StandardApplication {
        MobileDocument()
    }
    app.openDocument()
}