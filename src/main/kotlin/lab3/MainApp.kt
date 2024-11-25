package lab3

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class MainApp {
    private val gasDiningService = PeopleDinner()
    private val electricDiningService = RobotDinner()
    private val gasRefuelingService = GasStation()
    private val electricRefuelingService = ElectricStation()

    private val gasQueue = LinkedListQueue<Car>()
    private val electricQueue = LinkedListQueue<Car>()

    private val gasStation = CarStation(gasDiningService, gasRefuelingService, gasQueue)
    private val electricStation = CarStation(electricDiningService, electricRefuelingService, electricQueue)
    private val semaphore = Semaphore(gasStation, electricStation)

    private val objectMapper = ObjectMapper().registerKotlinModule()
    private val fileLock = ReentrantLock()

    fun start(folderPath: String, readInterval: Long, serveInterval: Long) {
        val scheduler = Executors.newScheduledThreadPool(2)

        // Task 1: Read JSON files and route cars
        scheduler.scheduleAtFixedRate({
            readAndRouteCars(folderPath)
        }, 0, readInterval, TimeUnit.SECONDS)

        // Task 2: Serve cars in each station
        scheduler.scheduleAtFixedRate({
            serveCars()
            Statistics.printStats()
        }, 0, serveInterval, TimeUnit.SECONDS)
    }

    private fun readAndRouteCars(folderPath: String) {
        fileLock.withLock {
            val folder = File(folderPath)
            if (folder.exists() && folder.isDirectory) {
                folder.listFiles { file -> file.extension == "json" }?.forEach { file ->
                    try {
                        val car = objectMapper.readValue<Car>(file)
                        semaphore.routeCar(car)
                        file.delete()
                    } catch (e: Exception) {
                        println("Error reading or processing file ${file.name}: ${e.message}")
                    }
                }
            }
        }
    }


    private fun serveCars() {
        gasStation.serveCars()
        electricStation.serveCars()
    }
}
