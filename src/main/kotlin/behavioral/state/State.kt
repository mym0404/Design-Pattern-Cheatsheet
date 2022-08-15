package behavioral.state

import behavioral.state.TCPState.Closed

class TCPConnection {
    var state: TCPState = Closed
        private set

    fun open() {
        state.open {
            state = it
        }
    }

    fun close() {
        state.close {
            state = it
        }
    }
}

sealed interface TCPState {
    fun open(changeState: (state: TCPState) -> Unit) {}
    fun close(changeState: (state: TCPState) -> Unit) {}

    object Established : TCPState {
        override fun open(changeState: (state: TCPState) -> Unit) {
            println("Established -> Listen")
            changeState(Listen)
        }

        override fun close(changeState: (state: TCPState) -> Unit) {
            println("Closed")
            changeState(Closed)
        }
    }

    object Listen : TCPState {
        override fun close(changeState: (state: TCPState) -> Unit) {
            println("Closed")
            changeState(Closed)
        }
    }

    object Closed : TCPState {
        override fun open(changeState: (state: TCPState) -> Unit) {
            println("Closed -> Established")
            changeState(Established)
        }
    }
}