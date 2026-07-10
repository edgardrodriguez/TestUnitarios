package service;

import org.example.service.IVACalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IvaCalculatorTest {
    IVACalculator calculator = new IVACalculator();
    @Test
    public void calculateIvaOK(){
        double result = calculator.calculateIVA(100);
        assertEquals(21.0,result,0.0001);
    }
    @Test
    public void calculateIvaZero(){
        double result = calculator.calculateIVA(0);
        assertEquals(0,result,0.0001);
    }
    @Test
    public void calculateIvaNegative(){
        double result = calculator.calculateIVA(-100);
        assertEquals(-21,result,0.0001);
    }
}
