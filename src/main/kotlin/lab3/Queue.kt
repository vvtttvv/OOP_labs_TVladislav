package lab3

interface Queue<T> {
    fun enqueue(item: T)
    fun dequeue(): T?
    fun peek(): T?
    fun size(): Int
    fun isEmpty(): Boolean
}
