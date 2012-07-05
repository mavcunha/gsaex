package com.gsaex;

import java.util.Iterator;

public class RowIterator<T> implements Iterator<Element> {

    private final Matrix matrix;
    private final Coord size;
    private final int currentM;
    private int currentN;

    public RowIterator(Matrix matrix, Coord coord) {
        this.matrix = matrix;
        this.size = matrix.size();
        this.currentM = coord.i();
    }

    @Override
    public boolean hasNext() {
        return currentN <= size.j();
    }

    @Override
    public Element next() {
        Element element = matrix.get(new Coord(currentM, currentN));
        currentN++;
        return element;
    }

    @Override
    public void remove() {
    }
}
