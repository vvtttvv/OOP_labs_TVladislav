package lab3

class ArrayListQueue<Car> : Queue<Car> {
    private val items = mutableListOf<Car>()

    override fun enqueue(item: Car) {
        items.add(item)
    }

    override fun dequeue(): Car? {
        return if (items.isEmpty()) null else items.removeAt(0)
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
