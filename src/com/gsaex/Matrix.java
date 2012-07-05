package com.gsaex;

public class Matrix {

    private final Coord size;
    private final int[][] matrix;

    public Matrix(String query, String subject) {
        size = new Coord(query.length(), subject.length());
        matrix = new int[query.length()][subject.length()];
    }

    public Coord size() {
        return this.size;
    }

    public void set(Coord coord, int value) {
        isValidCoord(coord);
        matrix[coord.m()-1][coord.n()-1] = value;
    }

    private void isValidCoord(Coord coord) {
        if (coord.m() > size.m() || coord.n() > size.n() || coord.m() < 1 || coord.n() < 1) {
            throw new InvalidCoordinateAccess();
        }
    }

    public int get(Coord coord) {
        isValidCoord(coord);
        return matrix[coord.m()-1][coord.n()-1];
    }

    public class InvalidCoordinateAccess extends RuntimeException {}
}
