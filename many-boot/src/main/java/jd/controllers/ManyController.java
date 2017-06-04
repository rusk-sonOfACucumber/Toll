package jd.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jdev on 04.06.2017.
 */
@RestController
public class ManyController {

    private static final Logger log = LoggerFactory.getLogger(ManyController.class);

    private int counter = 0;

    @RequestMapping("/increment")
    public State increment() {
        log.info(Thread.currentThread().getName() + " /increment");
        for (int i = 0; i < 1000; i++)
            this.counter++;
        return new State("ok");
    }

    @RequestMapping("/get")
    public int get() {
        log.info(Thread.currentThread().getName() + " /get");
        return counter;
    }

    @RequestMapping("/set")
    public int set(@RequestParam(value = "value") int value) {
        log.info(Thread.currentThread().getName() + " /set");
        return counter = value;
    }

}
