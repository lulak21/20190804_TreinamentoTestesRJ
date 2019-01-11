package br.com.k21;

public class CommissionCalculator {

    public int calculate(int saleAmount) {
        if(saleAmount<=1000000){
            return saleAmount * 5/100;
        }else {
            return saleAmount * 6/100;
        }
    }
}
