package jd.consumers.atom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jdev on 12.06.2017.
 */
public class StartExchange {
    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        new Producer().start();
        new Consumer().start();
    }
}
