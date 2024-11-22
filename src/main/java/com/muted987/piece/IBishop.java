package main.java.com.muted987.piece;

import main.java.com.muted987.Coordinates;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {
    default Set<CoordinatesShift> getBishopMoves() {
        //bottom-left to top right

        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, i));
        }
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, -i));
        }
        //top left to bottom right

        return result;
    };
}
