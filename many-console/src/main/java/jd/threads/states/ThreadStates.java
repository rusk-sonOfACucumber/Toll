package jd.threads.states;

/**
 * Created jdev on 07.06.2017.
 */
public class ThreadStates {

    public static void main (String[] args) throws InterruptedException {

        ThreadExample example = new ThreadExample();

        System.out.println("после создания, до запуска => " + example.getState());


        //запуск нити, но это не run()!!!!
        example.start();

        System.out.println("после запуска, до завершения => " + example.getState());

        //дожидаемся завершения
        example.join();

        System.out.println("после завершения => " + example.getState());

    }
}
