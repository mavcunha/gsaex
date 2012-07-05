package com.gsaex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void shouldBeCreateCoordinatesBasedOnSequenceSizes() {
        assertThat(new Matrix("AAAA", "CCCC").size(), is(new Coord(4, 4)));
    }

    @Test
    public void canChangeTheValueOfElement() {
        Matrix matrix = new Matrix("AAA", "CCC");
        assertThat(matrix.get(new Coord(3, 3)), is(0));
        matrix.set(new Coord(3, 3), 99);
        assertThat(matrix.get(new Coord(3, 3)), is(99));
    }

    @Test(expected = Matrix.InvalidCoordinateAccess.class)
    public void shouldThrowExceptionIfSetMGreaterThanSize() {
        new Matrix("AAA","CCC").set(new Coord(5,1),0);
    }

    @Test(expected = Matrix.InvalidCoordinateAccess.class)
    public void shouldThrowExceptionIfSetNGreaterThanSize() {
        new Matrix("AAA", "CCC").set(new Coord(1, 5), 0);
    }

    @Test(expected = Matrix.InvalidCoordinateAccess.class)
    public void shouldThrowExceptionIfGetMLessThanOne() {
        new Matrix("AAA", "CCC").get(new Coord(0, 1));
    }

    @Test(expected = Matrix.InvalidCoordinateAccess.class)
    public void shouldThrowExceptionIfGetNLessThanOne() {
        new Matrix("AAA", "CCCC").get(new Coord(1, 0));
    }
}
