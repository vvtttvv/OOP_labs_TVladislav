package lab3

class LinkedListQueue<T> : Queue<T> {
    private val items = ArrayDeque<T>()

    override fun enqueue(item: T) {
        items.addLast(item)
    }

    override fun dequeue(): T? {
        return if (items.isEmpty()) null else items.removeFirst()
    }

    override fun peek(): T? {
        return items.firstOrNull()
    }

    override fun size(): Int {
        return items.size
    }

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }
}
