package main.java.com.muted987;

import main.java.com.muted987.piece.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;

public class BoardConsoleRender {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[100m";
    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";
    public void render(Board board, Piece pieceToMove) {
        Set<Coordinates> availableMoveSquares = emptySet();
        if (pieceToMove != null) {
            availableMoveSquares = pieceToMove.getAvailableMoveSquares(board);
        }
        for (int rank = 8; rank >= 1; rank--) {
            StringBuilder line = new StringBuilder();
            for (File file : File.values()) {
             Coordinates coordinates = new Coordinates(file, rank);
             boolean isHighlight = availableMoveSquares.contains(coordinates);
                if (board.isSquareEmpty(coordinates)) {
                    line.append(getSpriteForEmptySquare(coordinates, isHighlight));
                }
                else {
                    line.append(getPieceSprite(board.getPiece(coordinates), isHighlight));
                }
            }
            line.append(ANSI_RESET + " ");
            System.out.println(line);
        }
//        for (File file : File.values()) {
//            System.out.print(" " + file + "ㅤ");
//        }
    }
    public void render(Board board) {
        render(board, null);
    }

    private String getPieceSprite(Piece piece, boolean isHighlight) {
        return colorizeSprite(" " + selectUnicodeSpriteForPiece(piece) + " ", piece.color , Board.isSquareDark(piece.coordinates), isHighlight);
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighlighted) {
        //format = background color + font color + text
        String result = sprite;
        if (isHighlighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        }
        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        }
        else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }
        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        }
        else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlight) {
        return colorizeSprite(" ㅤ ", Color.WHITE, Board.isSquareDark(coordinates), isHighlight);
    }

    private String selectUnicodeSpriteForPiece(Piece piece) {
        switch (piece.getClass().getSimpleName()){
            case "Pawn":
                return "♙";

            case "Knight":
                return "♞";

            case "Bishop":
                return "♝";

            case "Rook":
                return "♜";

            case "Queen":
                return "♛";

            case "King":
                return "♚";
        }
        return "1";
    }
}
