package com.gsaex;

import java.util.Iterator;

public class RowIterator<T> implements Iterator<Element> {

    private final Matrix matrix;
    private final Coord size;
    private final int row;
    private int column;

    public RowIterator(Matrix matrix, Coord coord) {
        this.matrix = matrix;
        this.size = matrix.size();
        this.row = coord.i();
    }

    @Override
    public boolean hasNext() {
        return column <= size.j();
    }

    @Override
    public Element next() {
        Element element = matrix.get(new Coord(row, column));
        column++;
        return element;
    }

    @Override
    public void remove() {
    }
}
