package controllers;

import jd.domain.Country;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jdev on 08.05.2017.
 *  Юнит тестирование
 */
public class CounterControllerTest {
    @Test
    public void greeting() throws Exception {
        CounterController controller = new CounterController();
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
        CounterController controller = new CounterController();
        Response result = controller.setCoords("lat56.4,lon34.6");
        assertEquals("ok", result.message);
        assertEquals(true, result.success);

        result = controller.setCoords("lat56.4");
        assertEquals("fail", result.message);
        assertEquals(false, result.success);
    }

    @Test
    public void relay() throws Exception {
        CounterController controller = new CounterController();
        Country result = controller.relay();
    }

}