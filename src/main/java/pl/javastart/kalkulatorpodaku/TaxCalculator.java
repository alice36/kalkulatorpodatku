package pl.javastart.kalkulatorpodaku;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculator {

    public double calculateTax(double income) {

        double podatek = 0;

        if(income < 86528) {
            podatek = 0.18 * income - 556;
        } else {
            podatek = 0.32 * income;
        }

        return podatek;
    }

}
