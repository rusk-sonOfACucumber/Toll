package jd.consumers.vol;

/**
 * Created by jdev on 12.06.2017.
 */
public class Consumer extends Thread {


    @Override
    public void run() {

        int local = StartExchange.counter;
        while (StartExchange.counter < 5) {
            if (local != StartExchange.counter)
            System.out.println(Thread.currentThread().getName() + ": счетчик изменился =>" + StartExchange.counter);
        }
    }
}
