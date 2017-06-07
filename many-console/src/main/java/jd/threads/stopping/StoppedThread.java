package jd.threads.stopping;

/**
 * Created by Boychenko.Ivan on 07.06.2017.
 */
public class StoppedThread extends Thread {
    public void setNeedStop(boolean needStop) {
        this.needStop = needStop;
    }

    private boolean needStop;

    @Override
    public void run() {
        for(;;) {
            if (needStop) {
                System.out.println("needStop == true -> exitting");
                break;
            }
        }
    }
}
