package com.gsaex.iterator;

import com.gsaex.Coord;
import com.gsaex.Element;
import com.gsaex.Matrix;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatrixIteratorTest {

    @Test
    public void hasNextReturnsTrueForNewlyCreatedIterator() {
        MatrixIterator iterator = new MatrixIterator(new Matrix("AAA", "CCC"));
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void hasNextReturnsFalseAfterGoThroughTheMatrix() {
        Matrix matrix = new Matrix("AAC", "CCC");
        Iterator<Element> iterator = new MatrixIterator(matrix);
        for (int i = 1; i <= (matrix.size().i()+1) * (matrix.size().j()+1); i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldBeAbleToBeTransversedInOrder() {
        Matrix matrix = new Matrix("AA", "CC");

        matrix.set(new Element(new Coord(0,0), 0));
        matrix.set(new Element(new Coord(0,1), 1));
        matrix.set(new Element(new Coord(0,2), 2));
        matrix.set(new Element(new Coord(1,0), 3));
        matrix.set(new Element(new Coord(1,1), 4));
        matrix.set(new Element(new Coord(1,2), 5));
        matrix.set(new Element(new Coord(2,0), 6));
        matrix.set(new Element(new Coord(2,1), 7));
        matrix.set(new Element(new Coord(2,2), 8));

        Iterator<Element> iterator = new MatrixIterator(matrix);

        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        for (int anExpected : expected) {
            assertThat(iterator.next().value(), is(equalTo(anExpected)));
        }
    }

    @Test
    public void shouldBeAbleToSetAUpperLimit() {
        Matrix matrix = new Matrix("AA", "CC");

        matrix.set(new Element(new Coord(1,1), 4));
        matrix.set(new Element(new Coord(1,2), 5));
        matrix.set(new Element(new Coord(2,1), 7));
        matrix.set(new Element(new Coord(2,2), 8));

        Iterator<Element> iterator = new MatrixIterator(matrix, new Coord(1,1));

        int[] expected = new int[]{4, 5, 7, 8};
        for (int anExpected : expected) {
            assertThat(iterator.next().value(), is(equalTo(anExpected)));
        }
    }
}
