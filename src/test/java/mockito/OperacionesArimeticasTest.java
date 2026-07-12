package mockito;

import org.example.pruebamock1.OperacionesAritmeticas;
import org.example.pruebamock1.OperacionesMatematicas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class OperacionesArimeticasTest {
    @Test
    public void ponderarTest(){
        OperacionesAritmeticas arimeticaMock =mock(OperacionesAritmeticas.class);
        OperacionesMatematicas operacion = new OperacionesMatematicas(arimeticaMock);
        double cantidadEntrada =10.0;
        double resultado = operacion.ponderar(cantidadEntrada);
        assertEquals(10.0,resultado,0.000001);
    }
}
