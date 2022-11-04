package lab.phb.forecastc.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class WebController {

    @RequestMapping("/")
    fun getRoot(model: Model): String {
        model.addAttribute("param", String())
      return "index"
    }

}