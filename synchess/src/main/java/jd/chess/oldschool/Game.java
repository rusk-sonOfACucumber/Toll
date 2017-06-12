package jd.chess.oldschool;

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

    public static void main(String... args) {
        ChessBoard board = new ChessBoard();
        Player white = new Player(true, board);
        Player black = new Player(false, board);
        white.start();
        black.start();
    }
}
