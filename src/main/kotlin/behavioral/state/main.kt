package behavioral.state

fun state() {
    val c = TCPConnection()

    c.open()
    c.close()

    c.open()
    c.open()
    c.close()
}