package lab3

fun testQueue(queue: Queue<Car>) {
    val car1 = Car(id = 1, type = "Sedan", passengers = "John, Alice", consumption = 8, isDining = false)
    val car2 = Car(id = 2, type = "SUV", passengers = "Bob", consumption = 12, isDining = true)
    val car3 = Car(id = 3, type = "Hatchback", passengers = "Charlie", consumption = 6, isDining = false)
    val car4 = Car(id = 3, type = "Hatchback", passengers = "Charlie", consumption = 6, isDining = false)

    queue.enqueue(car1)
    queue.enqueue(car2)
    queue.enqueue(car3)
    queue.enqueue(car4)

    assert(queue.size() == 4) { "Queue size should be 4" }

    assert(queue.peek()?.id == car1.id) { "Peek should return car1" }

    assert(queue.dequeue()?.id == car1.id) { "Dequeued car should be car1" }
    assert(queue.dequeue()?.id == car2.id) { "Dequeued car should be car1" }
    assert(queue.size() == 2) { "Queue size should be 2 after dequeue" }

    queue.dequeue()
    queue.dequeue()

    assert(queue.isEmpty()) { "Queue should be empty after removing all cars" }
}
