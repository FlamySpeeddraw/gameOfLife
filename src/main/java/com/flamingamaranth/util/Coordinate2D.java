package com.flamingamaranth.util;

public class Coordinate2D {
    private int x;
    private int y;

    public  Coordinate2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate2D that = (Coordinate2D) o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return this.x * 17 * 11 * 13 + this.y * 31 * 7 * 3;
    }

    @Override
    public String toString() {
        return "Coordonnées : x: " + this.x + " y: " + this.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
