package com.gsaex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElementTest {
    @Test
    public void shouldHaveACoord() {
        Element element = new Element(new Coord(1, 1), 0);
        assertThat(element.coord(), is(new Coord(1, 1)));
    }

    @Test
    public void shouldHaveAValue() {
        Element element = new Element(new Coord(1, 1), 999);
        assertThat(element.value(), is(999));
    }
}
