package controllers;

import jd.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by jdev on 08.05.2017.
 *  Юнит тестирование + использование Mockito для relay
 */
@RunWith(MockitoJUnitRunner.class)
public class CounterControllerTest {
    @Test
    public void greeting() throws Exception {
        CounterController controller = new CounterController(new RestTemplate());
        String name = "test name";
        CurrentState result = controller.greeting(name);
        assertEquals("It's yours, test name!", result.getContent());
        assertEquals(1, result.getId());

        name = "test2 name";
        result = controller.greeting(name);
        assertEquals("It's yours, test2 name!", result.getContent());
        assertEquals(2, result.getId());
    }

    @Test
    public void setCoords() throws Exception {
        CounterController controller = new CounterController(new RestTemplate());
        Response result = controller.setCoords("lat56.4,lon34.6");
        assertEquals("ok", result.message);
        assertEquals(true, result.success);

        result = controller.setCoords("lat56.4");
        assertEquals("fail", result.message);
        assertEquals(false, result.success);
    }

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    CounterController mockedController;



    @Test
    public void relay() throws Exception {
        when(restTemplate.getForObject("http://services.groupkt.com/country/get/iso2code/RU", Country.class)).thenReturn(new Country());
        Country result = mockedController.relay();
        assertNotNull(result);
    }

    @Test
    public void relayIntegration() throws Exception {
        Country result = new CounterController(new RestTemplate()).relay();
        assertNotNull(result);
        System.out.println(result.RestResponse.result.entrySet());
        assertEquals(result.RestResponse.result.get("alpha2_code"), "RU");
    }
}