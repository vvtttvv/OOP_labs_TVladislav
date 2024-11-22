package lab3

class LinkedListQueue<Car> : Queue<Car> {
    private val items = ArrayDeque<Car>()

    override fun enqueue(item: Car) {
        items.addLast(item)
    }

    override fun dequeue(): Car? {
        return if (items.isEmpty()) null else items.removeFirst()
    }

    override fun peek(): Car? {
        return items.firstOrNull()
    }

    override fun size(): Int {
        return items.size
    }

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }
}
