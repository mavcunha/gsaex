package com.gsaex.iterator;

import com.gsaex.Coord;
import com.gsaex.Element;
import com.gsaex.Matrix;

import java.util.Iterator;

public class ColumnIterator<T> implements Iterator<Element>, Iterable<Element> {

    private final Matrix matrix;
    private final Coord size;
    private final int currentColumn;
    private int currentRow;

    public ColumnIterator(Matrix matrix, Coord coord) {
        this.matrix = matrix;
        this.size = matrix.size();
        this.currentColumn = coord.j();
    }

    @Override
    public boolean hasNext() {
        return currentRow <= this.size.i();
    }

    @Override
    public Element next() {
        Element element = matrix.get(new Coord(currentRow, currentColumn));
        currentRow++;
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
