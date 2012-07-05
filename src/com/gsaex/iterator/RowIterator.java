package com.gsaex.iterator;

import com.gsaex.Coord;
import com.gsaex.Element;
import com.gsaex.Matrix;

import java.util.Iterator;

public class RowIterator<T> implements Iterator<Element>, Iterable<Element> {

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

    @Override
    public Iterator<Element> iterator() {
        return this;
    }
}
