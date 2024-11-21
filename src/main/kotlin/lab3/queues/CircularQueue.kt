package lab3

class CircularQueue<T>(private val capacity: Int) : Queue<T> {
    private val items = arrayOfNulls<Any>(capacity)
    private var head = 0
    private var tail = 0
    private var count = 0

    override fun enqueue(item: T) {
        if (count == capacity) throw IllegalStateException("Queue is full")
        items[tail] = item
        tail = (tail + 1) % capacity
        count++
    }

    override fun dequeue(): T? {
        if (count == 0) return null
        val item = items[head] as T
        items[head] = null
        head = (head + 1) % capacity
        count--
        return item
    }

    override fun peek(): T? {
        return if (count == 0) null else items[head] as T
    }

    override fun size(): Int {
        return count
    }

    override fun isEmpty(): Boolean {
        return count == 0
    }
}
