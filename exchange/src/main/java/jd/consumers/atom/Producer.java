package jd.consumers.atom;

/**
 * Created by jdev on 12.06.2017.
 */
public class Producer extends Thread {



    @Override
    public void run() {
        while (StartExchange.counter.get() < 5) {
            int local = StartExchange.counter.get();
            System.out.println(Thread.currentThread().getName() + ": Увеличение счетчика =>" + (local + 1));
            StartExchange.counter.incrementAndGet();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
