package main.java.com.muted987;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPositions();
        BoardConsoleRender renderer = new BoardConsoleRender();
        renderer.render(board);
    }
}
