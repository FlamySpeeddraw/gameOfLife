package com.flamingamaranth.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Coordinate2DTest {
    private Coordinate2D ca;
    private Coordinate2D cb;
    private Coordinate2D cc;

    @BeforeEach
    public void setup() {
        ca = new Coordinate2D(5, 12);
        cb = ca;
    }

    @Test
    @DisplayName("Complete test of the equals method")
    public void shouldTestMultipleAspectsOfEqualsMethod() {
        assertAll("Test of equals method",
            () -> {assertTrue(ca.equals(cb), "The same object reference should be true");System.out.println("AAAAAAAAAAA");},
            () -> assertTrue(ca.equals(new Coordinate2D(5, 12)), "The same coordinates (x and y) should be true"),
            () -> assertFalse(ca.equals(new Coordinate2D(4, 12)), "Differents coordinates (x) should be false"),
            () -> assertFalse(ca.equals(new Coordinate2D(5, 14)), "Differents coordinates (y) should be false"),
            () -> assertFalse(ca.equals(new Coordinate2D(8, 5)), "Differents coordinates (x and y) should be false"),
            () -> assertFalse(ca.equals(new Object()), "Non Coordinate2D should be false"),
            () -> assertFalse(ca.equals(cc), "Null param should be false")
        );
    }

    @Test
    @DisplayName("Test of the hashCode method")
    public void shouldHashTheObject() {
        assertEquals(ca.hashCode(), 19967);
    }

    @Test
    @DisplayName("Test of the toString method")
    public void shouldReturnTheClassnameAndAttributesAsString() {
        assertEquals(ca.toString(), "Coordonnées : x: 5 y: 12");
    }

    @Test
    @DisplayName("Test of the get method of x")
    public void shouldReturnTheValueOfX() {
        assertEquals(ca.getX(),5);
    }

    @Test
    @DisplayName("Test of the get method of y")
    public void shouldReturnTheValueOfY() {
        assertEquals(ca.getY(),12);
    }

    @Test
    @DisplayName("Test of the set method of x")
    public void shouldChangeTheValueOfX() {
        ca.setX(15);
        assertEquals(ca.getX(),15);
    }

    @Test
    @DisplayName("Test of the set method of y")
    public void shouldChangeTheValueOfY() {
        ca.setY(32);
        assertEquals(ca.getY(),32);
    }

}
