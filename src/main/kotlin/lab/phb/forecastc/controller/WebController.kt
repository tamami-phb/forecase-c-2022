package lab.phb.forecastc.controller

import lab.phb.forecastc.model.Parameter
import lab.phb.forecastc.repo.RekapPerTanggalRepo
import lab.phb.forecastc.util.LeastSquare
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class WebController {

    @Autowired
    lateinit var repo: RekapPerTanggalRepo
    val log = LoggerFactory.getLogger(WebController::class.java)

    @RequestMapping("/")
    fun getRoot(model: Model): String {
        model.addAttribute("param", Parameter())
      return "index"
    }

    @RequestMapping(value = ["/proses"], method = [ RequestMethod.POST ])
    fun proses(param: Parameter, model: Model): String {
        // TODO: calculate with least square
        log.info(param.tglAwal)
        log.info(param.tglAkhir)
        var data = repo.findByTglBetween(param.tglAwal, param.tglAkhir)
        var result = LeastSquare.calculate(data)
        model.addAttribute("hasil", result)
        return "result"
    }

}