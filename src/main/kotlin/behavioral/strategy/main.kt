package behavioral.strategy

fun strategy() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val readInt = {
        nextToken(); nval.toInt()
    }

    val v = readInt()
    val e = readInt()
    val s = readInt() - 1

    val edges = ArrayList<MutableList<Pair<Int, Int>>>()
    repeat(v) { edges.add(mutableListOf()) }

    for (i in 0 until e) {
        val a = readInt() - 1
        val b = readInt() - 1
        val w = readInt()

        edges[a].add(b to w)
    }

    val calculator = ShortestPathCalculator(edges, ShortestPathDijkstraStrategy())
    val answer = calculator.findShortestPathArray(s)
    repeat(v) {
        if (answer[it] == Int.MAX_VALUE) println("INF")
        else println(answer[it])
    }
}