package jd.chess.best;

import java.util.concurrent.BlockingDeque;

/**
 * Created by jdev on 12.06.2017.
 */
public class Player extends Thread {
    private final boolean isWhite;
    private final BlockingDeque<String> outDeque;
    private final BlockingDeque<String> inDeque;
    private int turns = 0;

    /**
     * Конструктор для игры Церными
     * @param outDeque - выходная очередь ходов
     * @param inDeque - входная очередь ходов
     * @throws InterruptedException - при работе с блокирующими операциями BlockingDeque
     */
    public Player(BlockingDeque<String> outDeque, BlockingDeque<String> inDeque) {
        this.outDeque = outDeque;
        this.inDeque = inDeque;
        isWhite = false;
    }

    /**
     * Конструктор для игры Белыми
     * @param outDeque - выходная очередь ходов
     * @param inDeque - входная очередь ходов
     * @param firstTurn - первый ход
     * @throws InterruptedException - при работе с блокирующими операциями BlockingDeque
     */
    public Player(BlockingDeque<String> outDeque, BlockingDeque<String> inDeque, String firstTurn) throws InterruptedException {
        this.outDeque = outDeque;
        this.inDeque = inDeque;
        isWhite = true;
        System.out.println(Thread.currentThread().getName() + ": " +"Белые делают первый ход => " + firstTurn);
        outDeque.put(firstTurn);
        turns++;
    }

    /**
     * Мето run для реализации действий игрока в отдельном потоке
     */
    @Override
    public void run() {
        //какими играю?
        String counterPart = isWhite ? "Чёрных" : "Белых";
        String figures = isWhite ? "Белые" : "Черные";
        while (turns < Game.gambit.length) {
            try {
                //ожидание хода противника
                String turn = inDeque.take();
                System.out.println(Thread.currentThread().getName() + ":" + " Получен ход " + counterPart + " => " + turn);

                //случайная задержка перед следующим ходом, подумать...
                long millis = (long) (Math.random() * 2000);
                System.out.println(Thread.currentThread().getName() + ": " + figures + " думают => " + millis);
                Thread.sleep(millis);

                //делаем ход
                String nextTurn = isWhite ? Game.gambit[turns][0] : Game.gambit[turns][1];
                System.out.println(Thread.currentThread().getName() + ": " + figures + " ходят => " + nextTurn);
                outDeque.put(nextTurn);

                //увеличиваем номер хода
                turns++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
