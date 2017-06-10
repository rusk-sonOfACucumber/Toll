package jd.threads.states;

/**
 * Created by jdev on 07.06.2017.
 */
public class ThreadExample extends Thread{

    @Override
    public void run() {
        System.out.println("это ThreadExample - выполняется в нити => " + Thread.currentThread().getName());
        int i = 0;
        for (;;) {
            i++;
            if (i > 2_000_000) break;
        }
    }
}
