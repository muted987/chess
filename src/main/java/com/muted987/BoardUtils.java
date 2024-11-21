package main.java.com.muted987;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates source, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();
        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rankShift = source.rank < target.rank ? 1 : -1;

        for (
                int fileIndex = source.file.ordinal() + fileShift,
                rank = source.rank + rankShift;
                fileIndex != target.file.ordinal() && rank != target.rank;
                fileIndex += fileShift, rank += rankShift
        ) {
            result.add(new Coordinates(File.values()[fileIndex], rank));
        }
        return result;
    }

    public static List<Coordinates> getRowsCoordinatesBetween(Coordinates source, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();
        int fileShift = Integer.compare(target.file.ordinal(), source.file.ordinal());
        int rankShift = Integer.compare(target.rank, source.rank);
        for (
                int fileIndex = fileShift == 0 ? fileShift : fileShift + source.file.ordinal(),
                rank = rankShift == 0 ? rankShift : rankShift + source.rank;
                fileIndex != target.file.ordinal() + 1 && rank != target.rank;
                rank += rankShift, fileIndex += fileShift
        ){
            result.add(new Coordinates(File.values()[fileIndex], rank));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Coordinates> list = getRowsCoordinatesBetween(new Coordinates(File.E, 5), new Coordinates(File.E, 1));
        System.out.println("list = " + list);
    }
}
