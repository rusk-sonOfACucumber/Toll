package jd.chess.oldschool;

/**
 * Created by jdev on 12.06.2017.
 */
public class Player extends Thread {
    private final boolean isWhite;
    private final ChessBoard board;
    private int turns = 0;

    public Player(boolean isWhite, ChessBoard board) {
        this.isWhite = isWhite;
        this.board = board;
    }

    @Override
    public void run() {

        while (turns < Game.gambit.length) {
            if (isWhite) {
                makeTurn(Game.gambit[turns][0]); // играю белыми и первым делаю ход
                waitContraTurn(); //жду ответа черных
            } else {
                waitContraTurn(); // играю черными и начинаю с ожидания хода белых
                makeTurn(Game.gambit[turns][1]); //делаю ответный ход
            }
            turns ++;
        }
    }

    private void waitContraTurn() {
        String turn = board.waitTurn(!isWhite);
        String counterPart = isWhite ? "Чёрных" : "Белых";
        System.out.println(Thread.currentThread().getName() + ":" + " Получен ход " + counterPart + " => " + turn);
    }

    private void makeTurn(String turn) {
        String figures = isWhite ? "Белые" : "Черные";
        try {

            long millis = (long) (Math.random() * 2000);
            System.out.println(Thread.currentThread().getName() + ": " + figures + " думают => " + millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " +figures + " ходят => " + turn);
        board.makeTurn(turn, isWhite);
    }
}
