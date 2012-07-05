package com.gsaex;

public class Coord {

    private final int i;
    private final int j;

    public Coord(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Coord left() {
        return new Coord(this.i, this.j - 1);
    }

    public Coord right() {
        return new Coord(this.i, this.j + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (i != coord.i) return false;
        if (j != coord.j) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
