package mockito;

import org.example.domain.SmartWatch;
import org.example.domain.pieces.Battery;
import org.example.domain.pieces.CPU;
import org.example.domain.pieces.HealthMonitor;
import org.example.domain.pieces.RAM;
import org.example.service.SmartWatchServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SmartWatchServiceImplTest {
    private SmartWatchServiceImpl service;

    @Before
    public void setUp(){
        service = new SmartWatchServiceImpl();
    }
    //nuevo celular
    @Test
    public void saveSmartTest() {
        SmartWatch newSmart = new SmartWatch(null, "XIAMI", new RAM(1L, "DDR4", 2),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                true,
                new HealthMonitor(1L, 0.0, 0));

        SmartWatch result = service.save(newSmart);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("XIAMI",result.getName());
    }
    @Test
    public void saveSmartTestZERO() {
        SmartWatch newSmart = new SmartWatch(0L, "XIAMI", new RAM(1L, "DDR4", 2),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                true,
                new HealthMonitor(1L, 0.0, 0));

        SmartWatch result = service.save(newSmart);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("XIAMI",result.getName());
    }
    @Test
    public void saveUpdateSmartTest() {
        SmartWatch newSmart = new SmartWatch(1L, "update", new RAM(1L, "DDR4", 2),
                new Battery(1L, 4500.0),
                new CPU(1L, 4),
                true,
                new HealthMonitor(1L, 0.0, 0));

        SmartWatch result = service.save(newSmart);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("update",result.getName());
    }
}
