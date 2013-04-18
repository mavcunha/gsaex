package com.gsaex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AlignmentTest {

    @Test
    public void shouldTakeIntoAccountASimilarityMatrix() {
        SimilarityMatrix similarityMatrix = new SimilarityMatrix();
        similarityMatrix.addPairScore('A','A', 10);

        Matrix expectedMatrix = new Matrix("AA", "AA");
        expectedMatrix.set(new Element(new Coord(0,0), 0));
        expectedMatrix.set(new Element(new Coord(0,1), -10));
        expectedMatrix.set(new Element(new Coord(0,2), -20));
        expectedMatrix.set(new Element(new Coord(1,0), -10));
        expectedMatrix.set(new Element(new Coord(1,1), 10));
        expectedMatrix.set(new Element(new Coord(1,2), 0));
        expectedMatrix.set(new Element(new Coord(2,0), -20));
        expectedMatrix.set(new Element(new Coord(2,1), 0));
        expectedMatrix.set(new Element(new Coord(2,2), 20));

        Matrix scoreMatrix = new Alignment("AA", "AA", similarityMatrix).scoreMatrix(-10);

        assertThat(scoreMatrix, is(equalTo(expectedMatrix)));
    }
}
