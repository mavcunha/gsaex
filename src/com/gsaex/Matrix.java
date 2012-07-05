package com.gsaex;

import java.util.Iterator;

public class Matrix implements Iterable<Element> {

    private final Coord size;
    private final int[][] matrix;

    public Matrix(String query, String subject) {
        size = new Coord(query.length(), subject.length());
        matrix = new int[query.length()][subject.length()];
    }

    public Coord size() {
        return this.size;
    }

    public void set(Element element) {
        Coord coord = element.coord();
        isValidCoord(coord);
        matrix[coord.m()-1][coord.n()-1] = element.value();
    }

    private void isValidCoord(Coord coord) {
        if (coord.m() > size.m() || coord.n() > size.n() || coord.m() < 1 || coord.n() < 1) {
            throw new InvalidCoordinateAccess("Matrix size:" + size + " coord:" + coord);
        }
    }

    public Element get(Coord coord) {
        isValidCoord(coord);
        return new Element(coord, matrix[coord.m()-1][coord.n()-1]);
    }

    @Override
    public Iterator<Element> iterator() {
        return new MatrixIterator(this);
    }

    public class InvalidCoordinateAccess extends RuntimeException {
        public InvalidCoordinateAccess(String message) {
            super(message);
        }
    }

}
