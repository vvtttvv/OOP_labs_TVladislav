package lab3

fun testQueue(queue: Queue<Int>) {

    assert(queue.size() == 3) { "Queue size should be 3" }

    assert(queue.peek() == 1) { "Peek should return 1" }

    assert(queue.dequeue() == 1) { "Dequeued item should be 1" }
    assert(queue.size() == 2) { "Queue size should be 2 after dequeue" }

    queue.dequeue()
    queue.dequeue()
    assert(queue.isEmpty()) { "Queue should be empty after removing all items" }
}

