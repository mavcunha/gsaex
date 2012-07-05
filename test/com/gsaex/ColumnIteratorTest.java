package com.gsaex;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ColumnIteratorTest {
    @Test
    public void hasNextReturnsTrueForNewlyCreatedIterator() {
        ColumnIterator<Element> iterator = new ColumnIterator<Element>(new Matrix("AAA", "CCC"), new Coord(1,2));
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void hasNextReturnsFalseAfterGoThroughTheRow() {
        Matrix matrix = new Matrix("AAA", "CCC");
        Iterator<Element> iterator = new ColumnIterator<Element>(matrix, new Coord(2,2));
        for (int i = 0; i <= matrix.size().j(); i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldBeAbleToBeTransversedInOrder() {
        Matrix matrix = new Matrix("AA", "CC");

        matrix.set(new Element(new Coord(0,1), 3));
        matrix.set(new Element(new Coord(1,1), 4));
        matrix.set(new Element(new Coord(2,1), 5));

        Iterator<Element> iterator = matrix.column(new Coord(1,1));

        int[] expected = new int[]{3, 4, 5};
        for (int anExpected : expected) {
            assertThat(anExpected, is(iterator.next().value()));
        }
    }
}
