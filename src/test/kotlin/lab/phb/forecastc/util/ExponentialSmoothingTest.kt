package lab.phb.forecastc.util

import lab.phb.forecastc.repo.RekapPerTanggalRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExponentialSmoothingTest {

    @Autowired
    lateinit var repo: RekapPerTanggalRepo
    val log = LoggerFactory.getLogger(ExponentialSmoothingTest::class.java)

    @Test
    fun getForecastTest() {
        var data = repo.findAll()
        var result = ExponentialSmoothing.getForecast(data)
        log.info("result : " + result)
        Assertions.assertNotNull(result)
    }

}