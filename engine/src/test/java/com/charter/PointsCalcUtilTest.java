package com.charter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointsCalcUtilTest {
    // 0
    @Test
    public void testCalculatePointsForAmountLessThan50() {
        int amount = 30;
        int expectedPoints = 0;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }

    // 0
    @Test
    public void testCalculatePointsForAmountEqualTo50() {
        int amount = 50;
        int expectedPoints = 0;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }
    // 80-50
    @Test
    public void testCalculatePointsForAmountBetween50And100() {
        int amount = 80;
        int expectedPoints = 30;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }
    // 100-50
    @Test
    public void testCalculatePointsForAmountEqualTo100() {
        int amount = 100;
        int expectedPoints = 50;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }
    // 50*2+50
    @Test
    public void testCalculatePointsForAmountGreaterThan100() {
        int amount = 150;
        int expectedPoints = 150;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }

    // 100*2+ 50
    @Test
    public void testCalculatePointsForAmountEqualTo200() {
        int amount = 200;
        int expectedPoints = 250;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }

    // 200*2+50
    @Test
    public void testCalculatePointsForAmountGreaterThan200() {
        int amount = 250;
        int expectedPoints = 350;
        int actualPoints = PointsCalcUtil.calculatePoints(amount);
        assertEquals(expectedPoints, actualPoints);
    }
}
