package service;

import org.example.domain.SmartDevice;
import org.example.domain.SmartWatch;
import org.example.service.SmartDeviceFacade;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SmartDeviceFacadeTest {
    @Test
    public void createSmartPhoneTest(){
        SmartDevice result = SmartDeviceFacade.createSmartPhone();
        assertNotNull(result);
        assertNotNull(result.getCpu());
        assertNotNull(result.getCpu().getCores());
        assertNotNull(result.getCpu().getOn());
        assertNotNull(result.getRam());
        assertNotNull(result.getBattery());
    }
    @Test
    public void createSmartWatchTest(){
        SmartDevice result = SmartDeviceFacade.createSmartWatch();
        assertNotNull(result);
        assertNotNull(result.getCpu());
        assertNotNull(result.getCpu().getCores());
        assertNotNull(result.getCpu().getOn());
        assertNotNull(result.getRam());
        assertNotNull(result.getBattery());
        SmartWatch reloj = (SmartWatch) result;
        assertNotNull(reloj.getMonitor());
    }
}
