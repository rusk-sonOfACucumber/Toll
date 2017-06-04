/**
 * Created by jdev on 04.06.2017.
 */
public class WhereIsTheMany {
    static int account = 0;
    static int transNum = 10000;
    static int threadNum = 20;

    public static void main(String... args) throws InterruptedException {
        Runnable transaction = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                    for (int i = 0; i < transNum; i++) {
                        WhereIsTheMany.account++;
                }
            }
        };

        //создаем заданное число нитей, и запускаем их на выполнение
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(transaction);
            threads[i].start();
        }

        //начинаем ждать завершения всех нитей
        for (int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            thread.join();
        }
        //если мы здесь то значит все нити завершили выполнение, выводим результат
        System.out.println("account = [" + account + "]" + " must be = [" + transNum*threadNum + "]");

        //удивляемся если разница не равна нулю
        if (transNum*threadNum - account != 0)
            System.out.println("where is my : " + (transNum*threadNum - account) + "$ !!!!!");
    }
}
