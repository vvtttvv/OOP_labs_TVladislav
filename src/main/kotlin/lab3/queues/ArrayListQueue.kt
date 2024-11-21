package lab3

class ArrayListQueue<T> : Queue<T> {
    private val items = mutableListOf<T>()

    override fun enqueue(item: T) {
        items.add(item)
    }

    override fun dequeue(): T? {
        return if (items.isEmpty()) null else items.removeAt(0)
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
