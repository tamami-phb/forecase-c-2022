package lab.phb.forecastc.controller

import lab.phb.forecastc.model.Parameter
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class WebController {

    @RequestMapping("/")
    fun getRoot(model: Model): String {
        model.addAttribute("param", Parameter())
      return "index"
    }

    @RequestMapping(value = ["/proses"], method = [ RequestMethod.POST ])
    fun proses(param: Parameter, model: Model): String {
        // TODO: calculate with least square
        model.addAttribute("hasil", "Sistem sedang dibangun")
        return "result"
    }

}