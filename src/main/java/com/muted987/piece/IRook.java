package main.java.com.muted987.piece;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<CoordinatesShift> getRockMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = -7, j = 0; i <= 7; i++) {
            result.add(new CoordinatesShift(j, i));
            result.add(new CoordinatesShift(j, i));
            result.add(new CoordinatesShift(i, j));
            result.add(new CoordinatesShift(i, j));
        }
        return result;
    }
}
