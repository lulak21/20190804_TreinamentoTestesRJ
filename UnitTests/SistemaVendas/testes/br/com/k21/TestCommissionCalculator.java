package br.com.k21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCommissionCalculator {

    private CommissionCalculator calculator;

    @Before
    public void subject() {
        this.calculator = new CommissionCalculator();
    }

    @Test
    public void calculate_commission_on_sale_with_less_than_10k() {
        int saleAmount = 500000;
        int expectedCommission = 25000;


        int calculatedCommission = calculator.calculate(saleAmount);

        assertEquals(expectedCommission, calculatedCommission);

    }


    @Test
    public void calculate_commission_on_sale_with_equals_than_10k() {
        int saleAmount = 1000000;
        int expectedCommission = 50000;


        int calculatedCommission = calculator.calculate(saleAmount);

        assertEquals(expectedCommission, calculatedCommission);

    }

    @Test
    public void calculate_commission_on_sale_with_6000_value_expecting_300_result() {
        int saleAmount = 600000;
        int expectedCommission = 30000;


        int calculatedCommission = calculator.calculate(saleAmount);

        assertEquals(expectedCommission, calculatedCommission);

    }

    @Test
    public void calculate_commission_on_sale_with_more_than_10k() {
        int saleAmount = 1500000;
        int expectedCommission = 90000;


        int calculatedCommission = calculator.calculate(saleAmount);

        assertEquals(expectedCommission, calculatedCommission);

    }

    @Test
    public void calculate_commission_on_sale_with_20000_value_expecting_1200_result() {
        {
            int saleAmount = 2000000;
            int expectedCommission = 120000;


            int calculatedCommission = calculator.calculate(saleAmount);

            assertEquals(expectedCommission, calculatedCommission);

        }

    }

    @Test
    public void calculate_commission_on_sale_with_55_59_value_expecting_2_77_result() {
        int saleAmount = 55_59;
        int expectedCommission = 2_77;

        int calculatedCommission = calculator.calculate(saleAmount);

        assertEquals(expectedCommission, calculatedCommission);

    }

}
