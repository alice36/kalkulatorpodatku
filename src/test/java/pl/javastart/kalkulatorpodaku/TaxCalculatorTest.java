package pl.javastart.kalkulatorpodaku;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TaxCalculatorTest {

    @Test
    public void shouldReturn0For3089() {
        // given

        TaxCalculator taxCalculator = new TaxCalculator();
        double income = 3089;

        // when
        double tax = taxCalculator.calculateTax(income);

        // then
        assertThat(tax, is(0.));
    }

    // TODO 50 000 -> 8444
    // TODO 100 000 -> 19 470

}