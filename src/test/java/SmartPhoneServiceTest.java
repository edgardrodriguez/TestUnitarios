import org.example.domain.SmartPhone;
import org.example.domain.pieces.Battery;
import org.example.domain.pieces.CPU;
import org.example.domain.pieces.Camera;
import org.example.domain.pieces.RAM;
import org.example.service.SmartPhoneServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class SmartPhoneServiceTest {
    @Test
    public void SaveNullTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        try {
            service.save(null);
        }catch (IllegalArgumentException e){
            assertNotNull(e);
        }
    }
    @Test
    public void SaveNegativeTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        try {
            SmartPhone phone = new SmartPhone(-1L,"IHPONE",
                    new RAM(1234455L,"SNAP DRAGON",16),
                    new Battery(121212L,99999.99),
                    new CPU(123434L, 9),
                    true,
                    new Camera(1234L,"CAMARA HD",150.0));
            service.save(phone);
        }catch (IllegalArgumentException e){
            assertNotNull(e);
        }
    }
    @Test
    public void saveIdNullTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        SmartPhone phone = new SmartPhone(null,"IHPONE",
                new RAM(1234455L,"SNAP DRAGON",16),
                new Battery(121212L,99999.99),
                new CPU(123434L, 9),
                true,
                new Camera(1234L,"CAMARA HD",150.0));
        SmartPhone result = service.save(phone);
        assertNotNull(result);
    }
    @Test
    public void saveIdZeroTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        SmartPhone phone = new SmartPhone(0L,"IHPONE",
                new RAM(1234455L,"SNAP DRAGON",16),
                new Battery(121212L,99999.99),
                new CPU(123434L, 9),
                true,
                new Camera(1234L,"CAMARA HD",150.0));
        SmartPhone result = service.save(phone);
        assertNotNull(result);
    }
    @Test
    public void saveUpdateTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        SmartPhone phone = new SmartPhone(12L,"IHPONE",
                new RAM(1234455L,"SNAP DRAGON",16),
                new Battery(121212L,99999.99),
                new CPU(123434L, 9),
                true,
                new Camera(1234L,"CAMARA HD",150.0));

        SmartPhone result = service.save(phone);
        assertNotNull(result);
        SmartPhone phone1 =service.findOne(12L);
        assertEquals("IHPONE",phone1.getName());
    }
    @Test
    public void deleteNullTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        boolean result = service.delete(null);
        assertFalse(result);
    }
    @Test
    public void deleteSiContieneId(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        boolean result = service.delete(333L);
        assertFalse(result);
    }
    @Test
    public void deleteOkId(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        boolean result = service.delete(3L);
        assertTrue(result);
    }
    @Test
    public void deleteAllTest(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        service.deleteAll();
    }
    @Test
    public void testFindByWifi(){
        SmartPhoneServiceImpl service = new SmartPhoneServiceImpl();
        SmartPhone phone1 = new SmartPhone();
            phone1.setId(23L);
            phone1.setWifi(true);
        SmartPhone phone2 = new SmartPhone();
        phone2.setId(21L);
        phone2.setWifi(false);

        List<SmartPhone> result= service.findByWifi(true);
        assertEquals(2, result.size());
    }
}
