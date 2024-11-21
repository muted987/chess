package main.java.com.muted987;

import main.java.com.muted987.piece.*;

public class BoardFactory {

    private PieceFactory pieceFactory = new PieceFactory();
    public Board fromFEN(String fen) {
        //rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
        Board board = new Board();
        String[] parts = fen.split(" ");
        String piecePositions = parts[0];
        String[] fenRows = piecePositions.split("/");


        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;
            int iterator = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);
                if (Character.isDigit(fenChar)) {
                    iterator += Character.getNumericValue(fenChar) - 1;
                } else {
                    File file = File.values()[iterator];
                    Coordinates coordinates = new Coordinates(file, rank);
                    board.setPiece(coordinates, pieceFactory.fromFenChar(fenChar, coordinates));
                }
                iterator++;
            }
        }
        return board;
    }
}
