package lab.phb.forecastc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForecastCApplication

fun main(args: Array<String>) {
    println("test")
	runApplication<ForecastCApplication>(*args)
}
