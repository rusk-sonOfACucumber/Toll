package jd.chess.best;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by jdev on 12.06.2017.
 */
public class Game {

    public static String[][] gambit = {
            {"e2-e4",  "e7-e5"},
            {"Kg1-f3", "Kb8-c6"},
            {"Kb1-c3", "Kg8-f6"},
            {"d2-d4",  "e5:d4"},
            {"Kc3-d5", "Неожиданно!..."}};

    public static void main(String... args) throws InterruptedException {
        // очереди ходов для каждого игрока, единичный размер очереди гарантирует наличие только одного хода
        BlockingDeque<String> whiteTurns = new LinkedBlockingDeque<>(1);
        BlockingDeque<String> blackTurns = new LinkedBlockingDeque<>(1);

        // Инициализируем игроков, выходная очередь одного является входной очередью другого, и белые всегда ходят первыми
        Player white = new Player(whiteTurns, blackTurns, gambit[0][0]);
        Player black = new Player(blackTurns, whiteTurns);
        white.start();
        black.start();
    }
}
