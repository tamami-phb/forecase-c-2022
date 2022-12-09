package lab.phb.forecastc.repo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RekapPerTanggalRepoTest {

    @Autowired
    lateinit var repo: RekapPerTanggalRepo
    val log = LoggerFactory.getLogger(RekapPerTanggalRepoTest::class.java)

    @Test
    fun getAllTest() {
        var result = repo.findAll()
        result.forEach {
            log.info(it.toString())
        }
        Assertions.assertNotNull(result)
    }

    @Test
    fun findByTglBetweenTest() {
        var result = repo.findByTglBetween("2005-05-24", "2005-05-31")
        result.forEach {
            log.info(it.toString())
        }
        Assertions.assertNotNull(result)
    }

}