package com.gsaex;

import org.junit.Test;

import java.util.Iterator;

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
        Iterator<Element> iterator = new MatrixIterator(new Matrix("AAA", "CCC"));
        for (int i = 1; i <= 9; i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void shouldBeAbleToBeTransversedInOrder() {
        Matrix matrix = new Matrix("AA", "CC");

        matrix.set(new Element(new Coord(1,1),1));
        matrix.set(new Element(new Coord(1,2),2));
        matrix.set(new Element(new Coord(2,1),3));
        matrix.set(new Element(new Coord(2,2),4));

        Iterator<Element> iterator = matrix.iterator();

        int[] expected = new int[]{1, 2, 3, 4};
        for (int anExpected : expected) {
            assertThat(anExpected, is(iterator.next().value()));
        }
    }
}
