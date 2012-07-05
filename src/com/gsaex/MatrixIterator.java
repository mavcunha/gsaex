package com.gsaex;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Element> {

    private final Coord size;
    private int row;
    private int column;
    private final Matrix matrix;

    public MatrixIterator(Matrix matrix) {
        this.size = matrix.size();
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return row <= size.i() && column <= size.j();
    }

    @Override
    public Element next() {
        Element element = matrix.get(new Coord(row, column));
        incrementCoordinates();
        return element;
    }

    private void incrementCoordinates() {
        if(column < size.j()) {
            column++;
        } else {
            column = 0;
            row++;
        }
    }

    @Override
    public void remove() {
        // noop
    }

}
