package jd.consumers.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jdev on 12.06.2017.
 */
public class StartExchange {
    public static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static int counter = 0;

    public static void main(String[] args) {

        new Producer().start();
        new Consumer().start();
        new Consumer().start();
        new Consumer().start();
        new Consumer().start();
        new Consumer().start();
    }
}
