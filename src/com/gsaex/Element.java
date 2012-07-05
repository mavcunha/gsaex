package com.gsaex;

public class Element {

    private final Coord coord;
    private final int value;

    public Element(Coord coord, int value) {
        this.coord = coord;
        this.value = value;
    }

    public Coord coord() {
        return coord;
    }

    public int value() {
        return value;
    }
}
