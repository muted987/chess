package main.java.com.muted987;

import java.util.Objects;

public class Coordinates {
     public final File  file;
     public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && rank.equals(that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
