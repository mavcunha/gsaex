package com.gsaex;

public class Coord {

    private final int m;
    private final int n;

    public Coord(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public Coord left() {
        return new Coord(this.m, this.n - 1);
    }

    public Coord right() {
        return new Coord(this.m, this.n + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;

        if (m != coord.m) return false;
        if (n != coord.n) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = m;
        result = 31 * result + n;
        return result;
    }

    public int m() {
        return this.m;
    }

    public int n() {
        return this.n;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "m=" + m +
                ", n=" + n +
                '}';
    }
}
