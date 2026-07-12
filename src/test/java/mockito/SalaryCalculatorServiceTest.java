package mockito;

import org.example.domain.Employee;
import org.example.service.IRPFCalculator;
import org.example.service.IVACalculator;
import org.example.service.SalaryCalculatorService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SalaryCalculatorServiceTest {
    @Test
    public void calculatorSalaryOKTest(){
        IRPFCalculator irpfCalculatorMock = mock(IRPFCalculator.class);
        IVACalculator ivaCalculatorMock= mock(IVACalculator.class);

        SalaryCalculatorService service = new SalaryCalculatorService(irpfCalculatorMock,ivaCalculatorMock);
        Employee employee = new Employee();
        employee.setAge(54);

        when(irpfCalculatorMock.calculateIRPF(20000.0)).thenReturn(100.0);
        when(ivaCalculatorMock.calculateIVA(40000.0)).thenReturn(200.0);
        double result = service.calculateSalary(employee);
        assertEquals(35400.0, result,0.00001);
    }
}
