import org.example.service.SmartPhoneServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
}
