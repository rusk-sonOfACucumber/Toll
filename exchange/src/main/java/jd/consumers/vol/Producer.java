package jd.consumers.vol;

/**
 * Created by jdev on 12.06.2017.
 */
public class Producer extends Thread {



    @Override
    public void run() {
        while (StartExchange.counter < 5) {
            int local = StartExchange.counter;
            System.out.println(Thread.currentThread().getName() + ": Увеличение счетчика =>" + (local + 1));
            StartExchange.counter = ++local;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
