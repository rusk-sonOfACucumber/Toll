package jd.consumers.atom;

/**
 * Created by jdev on 12.06.2017.
 */
public class Consumer extends Thread {


    @Override
    public void run() {

        int local = StartExchange.counter.get();
        while (StartExchange.counter.get() < 5) {
            if (local != StartExchange.counter.get())
            System.out.println(Thread.currentThread().getName() + ": счетчик изменился =>" + StartExchange.counter.get());
        }
    }
}
