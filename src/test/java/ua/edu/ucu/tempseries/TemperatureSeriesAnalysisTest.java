package ua.edu.ucu.tempseries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis testSeries1;
    private TemperatureSeriesAnalysis testSeries2;

    @Before
    public void setup() {
        double[] tempSer1 = {7.5, 34.5, -41.99, -7.0};
        double[] tempSer2 = {6.66, -45, 0.3, -0.3, 107, 15, 78.87};

        TemperatureSeriesAnalysis testSeries1 = new TemperatureSeriesAnalysis(tempSer1);
        TemperatureSeriesAnalysis testSeries2 = new TemperatureSeriesAnalysis(tempSer2);

        this.testSeries1 = testSeries1;
        this.testSeries2 = testSeries2;

    }

    @Test
    public void testAverageWithOneElementArray() {
        double expected = 3.5;
        double[] temperatureSeries = {3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double actual = seriesAnalysis.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double expected = -1.7475;
        double actual = testSeries1.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testDeviation() {
        double expected = 48.09261613315096;
        double actual = testSeries2.deviation();
        assertEquals(expected, actual, 0.000001);

    }

    @Test
    public void testMin() {
        double expected = -45.0;
        double actual = testSeries2.min();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMax() {
        double expected = 107;
        double actual = testSeries2.max();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempClosestToZero() {
        double expected = 0.3;
        double actual = testSeries2.findTempClosestToZero();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempClosestToValue() {
        double expected = 15;
        double actual = testSeries2.findTempClosestToValue(16);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] expected = {-45.0, 0.3, -0.3};
        double[] actual = testSeries2.findTempsLessThen(5.6);
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] expected = {6.66, 0.3, -0.3, 107.0, 15.0, 78.87};
        double[] actual = testSeries2.findTempsGreaterThen(-6.8);
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testSummaryStatistics() {
        double expected = 107;
        double actual = testSeries2.summaryStatistics().maxTemp;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testAddTemps() {
        int expected = 11;
        int actual = testSeries2.addTemps(2, -9.7, 12, 19);
        assertEquals(expected, actual, 0);

    }
}
