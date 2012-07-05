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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (value != element.value) return false;
        if (coord != null ? !coord.equals(element.coord) : element.coord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coord != null ? coord.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Element{" +
                "coord=" + coord +
                ", value=" + value +
                '}';
    }
}
