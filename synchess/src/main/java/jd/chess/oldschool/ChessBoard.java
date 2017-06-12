package jd.chess.oldschool;

/**
 * Created by jdev on 12.06.2017.
 */
public class ChessBoard {
    private volatile boolean nextTurn = true; // кто сейчас должен ходить true -> Белые, false -> Черные
    private String lastTurn; // последний ход

    public synchronized void makeTurn(String turn, boolean color) {
        while (nextTurn != color) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println(Thread.currentThread().getName() + " на доске передвинуты фигуры => " + turn);
        this.lastTurn = turn;
        nextTurn = !color;
        notifyAll();
    }

    public synchronized String waitTurn(boolean fromColor) {
        while (nextTurn == fromColor) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        notifyAll();
        return lastTurn;
    }
}
