package jd.consumers.locks;

/**
 * Created by jdev on 12.06.2017.
 */
public class Producer extends Thread {



    @Override
    public void run() {
        while (StartExchange.counter < 5) {
            int local = StartExchange.counter;
            System.out.println(Thread.currentThread().getName() + ": Увеличение счетчика => " + (local + 1));
            StartExchange.readWriteLock.writeLock().lock();
            try {
                StartExchange.counter = ++local;
            } finally {
                //обязательно в finally иначе лок окажется захваченным навсегда
                StartExchange.readWriteLock.writeLock().unlock();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
