package com.gsaex;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void shouldBeCreateCoordinatesBasedOnSequenceSizes() {
        assertThat(new Matrix("QUERY", "SUBJECT").size(), is(new Coord(7, 5)));
    }

    @Test
    public void canChangeTheValueOfElement() {
        Matrix matrix = new Matrix("AAA", "CCC");
        assertThat(matrix.get(new Coord(3, 3)).value(), is(0));
        matrix.set(new Element(new Coord(3, 3), 99));
        assertThat(matrix.get(new Coord(3, 3)).value(), is(99));
    }

    @Test(expected = Matrix.OutOfMatrixBoundaryAccessException.class)
    public void shouldThrowExceptionIfSetMGreaterThanSize() {
        new Matrix("AAA","CCC").set(new Element(new Coord(5,1),0));
    }

    @Test(expected = Matrix.OutOfMatrixBoundaryAccessException.class)
    public void shouldThrowExceptionIfSetNGreaterThanSize() {
        new Matrix("AAA", "CCC").set(new Element(new Coord(1, 5), 0));
    }

    @Test(expected = Matrix.OutOfMatrixBoundaryAccessException.class)
    public void shouldThrowExceptionIfGetMLessThanZero() {
        new Matrix("AAA", "CCC").get(new Coord(-1, 1));
    }

    @Test(expected = Matrix.OutOfMatrixBoundaryAccessException.class)
    public void shouldThrowExceptionIfGetNLessThanZero() {
        new Matrix("AAA", "CCCC").get(new Coord(1, -1));
    }

    @Test
    public void twoMatrixAreTheSameIfHaveAllElementsEqualToEachOther() {
        Matrix matrix1 = new Matrix("QUERY", "SUBJECT");
        Matrix matrix2 = new Matrix("QUERY", "SUBJECT");
        assertEquals(matrix1, matrix2);
    }

    @Test
    public void shouldBeAbleToReturnASpecificRow() {
        List<Element> expectedElements = Arrays.asList(
                new Element(new Coord(1,0), 0),
                new Element(new Coord(1,1), 1),
                new Element(new Coord(1,2), 2)
        );

        Matrix matrix = new Matrix("AA", "CC");
        for (Element expectedElement : expectedElements)
            matrix.set(expectedElement);

        Iterator<Element> row = matrix.row(new Coord(1, 2));
        for (Element expected : expectedElements) {
            assertEquals(expected, row.next());
        }
    }

    @Test
    public void shouldBeAbleToReturnAsSpecificColumn() {
        List<Element> expectedElements = Arrays.asList(
                new Element(new Coord(0,1), 0),
                new Element(new Coord(1,1), 1),
                new Element(new Coord(2,1), 2)
        );

        Matrix matrix = new Matrix("AA", "CC");
        for (Element expectedElement : expectedElements)
            matrix.set(expectedElement);

        Iterator<Element> column = matrix.column(new Coord(2, 1));
        for (Element expected : expectedElements) {
            assertEquals(expected, column.next());
        }
    }
}
