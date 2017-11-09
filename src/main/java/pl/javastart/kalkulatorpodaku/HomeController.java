package pl.javastart.kalkulatorpodaku;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("input", new InputData());
        return "index";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public String calculate(InputData inpuData) {

        int income = inpuData.getIncome();

        double podatek = 0;

        if(income < 86528) {
            podatek = 0.18 * income - 556;
        } else {
            podatek = 0.32 * income;
        }


        return "Podatek do zapłacenia to : " + podatek + "zł";
    }

}
