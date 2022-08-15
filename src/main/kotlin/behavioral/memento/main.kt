package behavioral.memento

fun memento() {
    val text1 = Graphic()
    val text2 = Graphic()

    ConstraintSolver.addConstraint(text1, text2, 5 to 10)
    val cmd = MoveCommand(text2, 10 to 10)
    cmd.execute()

    assert(text2.x == 15 && text2.y == 20)

    cmd.unexecute()

    assert(text2.x == 5 && text2.x == 10)
}