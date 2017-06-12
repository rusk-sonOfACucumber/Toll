package jd.thredlocal;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jdev on 12.06.2017.
 */
public class Formatter implements Runnable {
    private static AtomicInteger cnt = new AtomicInteger(0);
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> {
        System.out.println(Thread.currentThread().getName() + ": init formatter => " + cnt.incrementAndGet());
        return new SimpleDateFormat("yyyyMMdd HHmm");
    });

    @Override
    public void run() {
        System.out.println(formatter.get().format(new Date(System.currentTimeMillis())));
    }
}
