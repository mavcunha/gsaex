package com.gsaex;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Element> {

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
    public Element next() {
        Element element = matrix.get(new Coord(currentM, currentN));
        incrementCoordinates();
        return element;
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
