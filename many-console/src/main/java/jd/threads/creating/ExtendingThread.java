package jd.threads.creating;

/**
 * Created by jdev on 07.06.2017.
 */
public class ExtendingThread extends Thread {

    @Override
    public void run() {
        //позволяет делать вызовы при вложенном наследовании, использовать опционально
        super.run();

        System.out.println("это ExtendingThread - наследник Thread выполняется в нити => " + Thread.currentThread().getName());

    }
}
