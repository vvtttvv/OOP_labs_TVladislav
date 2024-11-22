package lab3

interface Queue<Car> {
    fun enqueue(item: Car)
    fun dequeue(): Car?
    fun peek(): Car?
    fun size(): Int
    fun isEmpty(): Boolean
}
