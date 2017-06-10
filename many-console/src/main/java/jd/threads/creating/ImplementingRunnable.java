package jd.threads.creating;

/**
 * Created by jdev on 07.06.2017.
 */
public class ImplementingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("это ImplementingRunnable - имплементатор Runnable выполняется в нити => " + Thread.currentThread().getName());
    }
}
