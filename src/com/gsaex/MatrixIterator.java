package com.gsaex;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Element> {

    private final Coord size;
    private int currentM;
    private int currentN;
    private final Matrix matrix;

    public MatrixIterator(Matrix matrix) {
        this.size = matrix.size();
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return currentM <= size.i() && currentN <= size.j();
    }

    @Override
    public Element next() {
        Element element = matrix.get(new Coord(currentM, currentN));
        incrementCoordinates();
        return element;
    }

    private void incrementCoordinates() {
        if(currentN < size.j()) {
            currentN++;
        } else {
            currentN = 0;
            currentM++;
        }
    }

    @Override
    public void remove() {
        // noop
    }

}
