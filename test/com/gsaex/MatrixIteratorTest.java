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
        Iterator<Integer> iterator = new MatrixIterator(new Matrix("AAA", "CCC"));
        for (int i = 1; i <= 9; i++) {
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }
}
