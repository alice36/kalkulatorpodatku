package pl.javastart.kalkulatorpodaku;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired TaxCalculator taxCalculator;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("input", new InputData());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(InputData inputData, Model model) {

        int income = inputData.getIncome();

        double podatek = taxCalculator.calculateTax(income);

        model.addAttribute("tax", podatek);
        model.addAttribute("input", new InputData());

        return "index";
    }

}
