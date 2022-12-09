package lab.phb.forecastc.util

import lab.phb.forecastc.repo.RekapPerTanggalRepo
import lab.phb.forecastc.repo.RekapPerTanggalRepoTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LeastSquareTest {

    @Autowired
    lateinit var repo: RekapPerTanggalRepo
    val log = LoggerFactory.getLogger(LeastSquareTest::class.java)

    @Test
    fun calculateATest() {
        var data = repo.findAll()
        var a = LeastSquare.calculateA(data)
        log.info("" + a.toString())
        Assertions.assertNotNull(a)
    }

    @Test
    fun generateXGenapTest() {
        var result = LeastSquare.generateXGenap(6)
        result.forEach {
            log.info("" + it)
        }
        Assertions.assertNotNull(result)
    }

    @Test
    fun generateXGanjilTest() {
        var result = LeastSquare.generateXGanjil(5)
        result.forEach {
            log.info("" + it)
        }
        Assertions.assertNotNull(result)
    }

    @Test
    fun generateXYTest() {
        var data = repo.findAll()
        var x = LeastSquare.generateX(data.size)
        var result = LeastSquare.generateXY(x, data)
        log.info("" + result)
        Assertions.assertNotNull(result)
    }

    @Test
    fun calculateX2Test() {
        var result = LeastSquare.calculateX2(LeastSquare.generateX(41))
        log.info("" + result)
        Assertions.assertNotNull(result)
    }

    @Test
    fun calculateTest() {
        var data = repo.findAll()
        var result = LeastSquare.calculate(data)
        log.info("" + result)
        Assertions.assertNotNull(result)
    }

}