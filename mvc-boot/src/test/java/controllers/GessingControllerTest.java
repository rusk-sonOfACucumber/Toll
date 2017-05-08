package controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import services.FortuneService;

import static org.junit.Assert.*;

/**
 * Created by jdev on 08.05.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class GessingControllerTest {

    @Mock
    Model model;

    @Mock
    FortuneService fortuneService;

    @InjectMocks
    GessingController controller;


    @Test
    public void gess() throws Exception {
        String result = controller.gess("name", model);
        assertEquals("gessing", result);
    }

}