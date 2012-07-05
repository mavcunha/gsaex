package com.gsaex;

import com.gsaex.iterator.MatrixIterator;

public class Matrix {

    private final Coord size;
    private final int[][] matrix;

    public Matrix(String query, String subject) {
        size = new Coord(subject.length(), query.length());
        matrix = new int[subject.length() + 1][query.length() + 1];
    }

    public Coord size() {
        return this.size;
    }

    public void set(Element element) {
        Coord coord = element.coord();
        validateBoundary(coord);
        matrix[coord.i()][coord.j()] = element.value();
    }

    private void validateBoundary(Coord coord) {
        if (coord.i() > size.i() || coord.j() > size.j() || coord.i() < 0 || coord.j() < 0) {
            throw new OutOfMatrixBoundaryAccessException("Matrix size:" + size + " coord:" + coord);
        }
    }

    public Element get(Coord coord) {
        validateBoundary(coord);
        return new Element(coord, matrix[coord.i()][coord.j()]);
    }

    public class OutOfMatrixBoundaryAccessException extends RuntimeException {
        public OutOfMatrixBoundaryAccessException(String message) {
            super(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix otherMatrix = (Matrix) o;

        if (size != null ? !size.equals(otherMatrix.size) : otherMatrix.size != null) return false;

        for(Element e : new MatrixIterator(otherMatrix))
            if(!e.equals(this.get(e.coord())))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        return size != null ? size.hashCode() : 0;
    }

    @Override
    public String toString() {
        String matrix = "Matrix {";
        for (Element e : new MatrixIterator(this)) {
            matrix += e;
        }
        return matrix;
    }
}
