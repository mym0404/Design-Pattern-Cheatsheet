package behavioral.memento

class Graphic {
    var x = 0
        private set
    var y = 0
        private set

    fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }
}

data class Constraint(val target1: Graphic, val target2: Graphic, val delta: Pair<Int, Int>)

object ConstraintSolver {
    private val constraints = mutableListOf<Constraint>()
    fun createMemento(): ConstraintSolverMementoCareTaker {
        return ConstraintSolverMemento(constraints.toList()) // copy is needed
    }

    fun setState(memento: ConstraintSolverMementoCareTaker) {
        (memento as? ConstraintSolverMemento)?.run {
            this@ConstraintSolver.constraints.clear()
            this@ConstraintSolver.constraints.addAll(storedConstraints)
        }
    }

    fun addConstraint(target1: Graphic, target2: Graphic, delta: Pair<Int, Int>) {
        constraints.add(Constraint(target1, target2, delta))
        target2.move(-target2.x + delta.first, -target2.y + delta.second)
    }
}

interface ConstraintSolverMementoCareTaker
data class ConstraintSolverMemento(val storedConstraints: List<Constraint>) : ConstraintSolverMementoCareTaker

class MoveCommand(private val target: Graphic, private val delta: Pair<Int, Int>) {
    private lateinit var state: ConstraintSolverMementoCareTaker
    fun execute() {
        state = ConstraintSolver.createMemento()
        target.move(delta.first, delta.second)
    }

    fun unexecute() {
        target.move(-delta.first, -delta.second)
        ConstraintSolver.setState(state)
    }
}