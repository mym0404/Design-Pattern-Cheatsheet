package behavioral.strategy

import java.util.*
import kotlin.collections.ArrayList

interface ContextInterface {
    val edges: ArrayList<out List<Pair<Int, Int>>>
}

class ShortestPathCalculator(
    override val edges: ArrayList<out List<Pair<Int, Int>>> = arrayListOf(), private val strategy: ShortestPathStrategy
) : ContextInterface {
    fun findShortestPathArray(start: Int) = strategy.run {
        this@ShortestPathCalculator.findShortestPaths(start)
    }
}

interface ShortestPathStrategy {
    fun ContextInterface.findShortestPaths(start: Int): Array<Int>
}

class ShortestPathBFSStrategy : ShortestPathStrategy {
    override fun ContextInterface.findShortestPaths(start: Int): Array<Int> {
        val dist = Array(edges.size) { Int.MAX_VALUE }
        dist[start] = 0
        val q: Queue<Int> = LinkedList()
        q.offer(start)
        while (q.size > 0) {
            val cur = q.poll()
            for ((to, w) in edges[cur]) {
                if (dist[to] > dist[cur] + w) {
                    dist[to] = dist[cur] + w
                    q.offer(to)
                }
            }
        }
        return dist
    }
}

class ShortestPathDijkstraStrategy : ShortestPathStrategy {
    override fun ContextInterface.findShortestPaths(start: Int): Array<Int> {
        val dist = Array(edges.size) { Int.MAX_VALUE }
        dist[start] = 0
        val q = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }
        q.offer(0 to start)
        while (q.size > 0) {
            val (curD, cur) = q.poll()
            if (curD > dist[cur]) continue
            for ((to, w) in edges[cur]) {
                if (dist[to] > curD + w) {
                    dist[to] = curD + w
                    q.offer(dist[to] to to)
                }
            }
        }
        return dist
    }
}
