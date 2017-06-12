package jd.thredlocal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jdev on 12.06.2017.
 */
public class StartFormatters {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(3);
        Formatter formatter = new Formatter();
        for (int i=0; i<10; i++) {
            pool.submit(formatter);
        }
        //иначе основной поток не завершается
        pool.shutdown();
    }
}
