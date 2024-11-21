package lab3


fun main() {
    val queue = CircularQueue<Int>(3)
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    testQueue(queue)
    println("All tests passed!")
}