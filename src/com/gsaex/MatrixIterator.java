package com.gsaex;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {

    private final Coord size;
    private int currentM = 1;
    private int currentN = 1;
    private final Matrix matrix;

    public MatrixIterator(Matrix matrix) {
        this.size = matrix.size();
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return currentM <= size.m() && currentN <= size.n();
    }

    @Override
    public Integer next() {
        int value = matrix.get(new Coord(currentM, currentN));
        incrementCoordinates();
        return value;
    }

    private void incrementCoordinates() {
        if(currentN < size.n()) {
            currentN++;
        } else {
            currentN = 1;
            currentM++;
        }
    }

    @Override
    public void remove() {
        // noop
    }

}
