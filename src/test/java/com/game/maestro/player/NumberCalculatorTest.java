package com.game.maestro.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberCalculatorTest {

    private NumberCalculator calculator;

    @Before
    public void setUp() throws Exception {

        calculator = new NumberCalculator();
    }

    @Test
    public void calculateNext_with1_shouldReturn1() {
        assertEquals(1, calculator.findSmallerOrEqualHotNumber(1));
    }

    @Test
    public void calculateNext_with2_shouldReturn2() {
        assertEquals(2, calculator.findSmallerOrEqualHotNumber(2));
    }

    @Test
    public void calculateNext_with3_shouldReturn3() {
        assertEquals(3, calculator.findSmallerOrEqualHotNumber(3));
    }

    @Test
    public void calculateNext_with4_shouldReturn3() {
        assertEquals(3, calculator.findSmallerOrEqualHotNumber(4));
    }


    @Test
    public void calculateNext_with5_shouldReturn3() {
        assertEquals(5, calculator.findSmallerOrEqualHotNumber(5));
    }

    @Test
    public void calculateNext_with6_shouldReturn5() {
        assertEquals(5, calculator.findSmallerOrEqualHotNumber(6));
    }

    @Test
    public void calculateNext_with7_shouldReturn5() {
        assertEquals(5, calculator.findSmallerOrEqualHotNumber(7));
    }

    @Test
    public void calculateNext_with8_shouldReturn8() {
        assertEquals(8, calculator.findSmallerOrEqualHotNumber(8));
    }

    @Test
    public void calculateNext_with13_shouldReturn8() {
        assertEquals(13, calculator.findSmallerOrEqualHotNumber(13));
    }

    @Test
    public void calculateNext_with12_shouldReturn8() {
        assertEquals(8, calculator.findSmallerOrEqualHotNumber(12));
    }
    @Test
    public void calculateNext_with14_shouldReturn13() {
        assertEquals(13, calculator.findSmallerOrEqualHotNumber(14));
    }
    @Test
    public void calculateNext_with20_shouldReturn13() {
        assertEquals(13, calculator.findSmallerOrEqualHotNumber(20));
    }





}