package com.gsaex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class CoordTest {
    @Test
    public void canReturnLeft() {
        assertThat(new Coord(5, 5).left(), is(new Coord(5, 4)));
    }

    @Test
    public void canReturnRight() {
        assertThat(new Coord(5, 5).right(), is(new Coord(5, 6)));
    }

    @Test
    public void coordsAreEqualIfHaveTheSameMN() {
        assertThat(new Coord(5, 6), is(new Coord(5, 6)));
    }

    @Test
    public void coordsDifferIfHaveDifferentMN() {
        assertThat(new Coord(5, 6), is(not(new Coord(6, 6))));
    }

    @Test
    public void individualNCoordIsAvailable() {
        assertThat(new Coord(2, 2).n(), is(2));
    }

    @Test
    public void individualMCoordIsAvailable() {
        assertThat(new Coord(3, 3).m(), is(3));
    }
}
