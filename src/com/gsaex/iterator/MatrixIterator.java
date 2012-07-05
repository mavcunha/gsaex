package com.gsaex.iterator;

import com.gsaex.Coord;
import com.gsaex.Element;
import com.gsaex.Matrix;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Element>, Iterable<Element> {

    private final Coord size;
    private int row;
    private int column;
    private final Matrix matrix;
    private Coord upperLimit;

    public MatrixIterator(Matrix matrix, Coord upperLimit) {
        this.matrix = matrix;
        this.size = matrix.size();
        row = upperLimit.i();
        column = upperLimit.j();
        this.upperLimit = upperLimit;
    }

    public MatrixIterator(Matrix matrix) {
        this(matrix, new Coord(0, 0));
    }

    @Override
    public Iterator<Element> iterator() {
        return this;
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
            column = this.upperLimit.j();
            row++;
        }
    }

    @Override
    public void remove() {
        // noop
    }
}
