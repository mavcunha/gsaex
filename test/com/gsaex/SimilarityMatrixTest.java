package com.gsaex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimilarityMatrixTest {
    @Test
    public void shouldReturnTheScoreForTwoSimilarBases() {
        SimilarityMatrix matrix = new SimilarityMatrix();
        matrix.addPairScore('A','B',5);
        assertThat(matrix.score('A', 'B'), is(5));
    }

    @Test
    public void shouldAcceptMoreThanOneBasePairScore() {
        SimilarityMatrix matrix = new SimilarityMatrix();

        matrix.addPairScore('A','A', 10);
        matrix.addPairScore('A','B', 5);

        assertThat(matrix.score('A', 'A'), is(10));
        assertThat(matrix.score('A', 'B'),is(5));
    }

    @Test
    public void thePairScoreIsCommutative() {
        SimilarityMatrix matrix = new SimilarityMatrix();

        matrix.addPairScore('A','B', 5);

        assertThat(matrix.score('A','B'), is(5));
        assertThat(matrix.score('B','A'), is(5));
    }

    @Test(expected = SimilarityMatrix.BaseNotDefinedInMatrix.class)
    public void raiseExceptionIfBaseDoesNotExists() {
        new SimilarityMatrix().score('A','A');
    }

    @Test
    public void addingSamePairScoreRedefinesScore() {
        SimilarityMatrix matrix = new SimilarityMatrix();

        matrix.addPairScore('A','A', 10);
        assertThat(matrix.score('A', 'A'), is(10));

        matrix.addPairScore('A','A',5);
        assertThat(matrix.score('A','A'), is(5));
    }

    @Test
    public void addingSamePairScoreRedefinitionIsCommutative() {
        SimilarityMatrix matrix = new SimilarityMatrix();

        matrix.addPairScore('A','B', 10);
        assertThat(matrix.score('A','B'), is(10));

        matrix.addPairScore('B','A',5);
        assertThat(matrix.score('A', 'B'), is(5));
    }
}
