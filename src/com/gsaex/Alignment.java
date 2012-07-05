package com.gsaex;

import com.gsaex.iterator.ColumnIterator;
import com.gsaex.iterator.MatrixIterator;
import com.gsaex.iterator.RowIterator;

public class Alignment {

    private final Matrix matrix;
    private final SimilarityMatrix similarityMatrix;
    private final char[] query;
    private final char[] subject;

    public Alignment(String query, String subject, SimilarityMatrix similarityMatrix) {
        this.matrix = new Matrix(query, subject);
        this.query   = query.toCharArray();
        this.subject = subject.toCharArray();
        this.similarityMatrix = similarityMatrix;
    }

    public Matrix scoreMatrix(int gapPenalty) {
        populateScoreMatrixFirstRow(gapPenalty);
        populateScoreMatrixFirstColumn(gapPenalty);

        return computeScores(gapPenalty);
    }

    private Matrix computeScores(int gapPenalty) {
        for (Element e : new MatrixIterator(this.matrix, new Coord(1, 1))) {
            this.matrix.set(new Element(e.coord(),
                    max(
                            this.matrix.get(e.coord().up()),
                            this.matrix.get(e.coord().diag()),
                            this.matrix.get(e.coord().left()),
                            gapPenalty
                    )));
        }
        return this.matrix;
    }

    private int max(Element up, Element diag, Element left, int gapPenalty) {
        return Math.max(
                        up.value() + gapPenalty,
                Math.max(
                        diag.value() + similarityScore(diag),
                        left.value() + gapPenalty
                ));
    }

    private int similarityScore(Element diag) {
        return this.similarityMatrix.score(
                this.query[diag.coord().j()],
                this.subject[diag.coord().i()]);
    }

    private void populateScoreMatrixFirstColumn(int gapPenalty) {
        for (Element e : new ColumnIterator<Element>(this.matrix, new Coord(0, 0)))
            this.matrix.set(new Element(e.coord(), e.coord().i() * gapPenalty));
    }

    private void populateScoreMatrixFirstRow(int gapPenalty) {
        for (Element e : new RowIterator<Element>(this.matrix, new Coord(0, 0)))
            this.matrix.set(new Element(e.coord(), e.coord().j() * gapPenalty));
    }
}
