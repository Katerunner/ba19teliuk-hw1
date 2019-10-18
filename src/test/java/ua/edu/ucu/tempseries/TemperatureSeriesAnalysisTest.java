package ua.edu.ucu.tempseries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis testSeries1;
    private TemperatureSeriesAnalysis testSeries2;
    private TemperatureSeriesAnalysis testSeries3;
    private TemperatureSeriesAnalysis testSeries4;


    @Before
    public void setup() {
        double[] tempSer1 = {7.5, 34.5, -41.99, -7.0};
        double[] tempSer2 = {6.66, -45, 0.3, -0.3, 107, 15, 78.87};
        double[] tempSer3 = {1.7};
        double[] tempSer4 = {-212.88, 346.123456, 3.243546};


        TemperatureSeriesAnalysis testSeries1 = new TemperatureSeriesAnalysis(tempSer1);
        TemperatureSeriesAnalysis testSeries2 = new TemperatureSeriesAnalysis(tempSer2);
        TemperatureSeriesAnalysis testSeries3 = new TemperatureSeriesAnalysis(tempSer3);
        TemperatureSeriesAnalysis testSeries4 = new TemperatureSeriesAnalysis(tempSer4);


        this.testSeries1 = testSeries1;
        this.testSeries2 = testSeries2;
        this.testSeries3 = testSeries3;
        this.testSeries4 = testSeries4;


    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.average();
    }

    @Test(expected = InputMismatchException.class)
    public void testToSmallTemperature() {
        double[] temperatureSeries = {-2345.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverage1() {
        double expected = -1.7475;
        double actual = testSeries1.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverage2() {
        double expected = 23.21857142857143;
        double actual = testSeries2.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverage3() {
        double expected = 1.7;
        double actual = testSeries3.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testAverage4() {
        double expected = 45.49566733333333;
        double actual = testSeries4.average();
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void testDeviation1() {
        double expected = 27.59730546176565;
        double actual = testSeries1.deviation();
        assertEquals(expected, actual, 0.000001);

    }

    @Test
    public void testDeviation2() {
        double expected = 48.09261613315096;
        double actual = testSeries2.deviation();
        assertEquals(expected, actual, 0.000001);

    }

    @Test
    public void testDeviation3() {
        double expected = 0;
        double actual = testSeries3.deviation();
        assertEquals(expected, actual, 0.000001);

    }

    @Test
    public void testDeviation4() {
        double expected = 230.15957836953189;
        double actual = testSeries4.deviation();
        assertEquals(expected, actual, 0.000001);

    }

    @Test
    public void testMin1() {
        double expected = -41.99;
        double actual = testSeries1.min();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMin2() {
        double expected = -45.0;
        double actual = testSeries2.min();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMin3() {
        double expected = 1.7;
        double actual = testSeries3.min();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMin4() {
        double expected = -212.88;
        double actual = testSeries4.min();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMax1() {
        double expected = 34.5;
        double actual = testSeries1.max();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMax2() {
        double expected = 107;
        double actual = testSeries2.max();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMax3() {
        double expected = 1.7;
        double actual = testSeries3.max();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testMax4() {
        double expected = 346.123456;
        double actual = testSeries4.max();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempClosestToZero1() {
        double expected = -7;
        double actual = testSeries1.findTempClosestToZero();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempClosestToZero2() {
        double expected = 0.3;
        double actual = testSeries2.findTempClosestToZero();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempClosestToZero3() {
        double expected = 1.7;
        double actual = testSeries3.findTempClosestToZero();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempClosestToZero4() {
        double expected = 3.243546;
        double actual = testSeries4.findTempClosestToZero();
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
    public void testFindTempsLessThenMinimum() {
        double[] expected = {};
        double[] actual = testSeries2.findTempsLessThen(-273);
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempsLessLarger() {
        double[] expected = {6.66, -45, 0.3, -0.3, 15, 78.87};
        double[] actual = testSeries2.findTempsLessThen(testSeries2.max());
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] expected = {6.66, 107.0, 15.0, 78.87};
        double[] actual = testSeries2.findTempsGreaterThen(1);
        Assert.assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testFindTempsGreaterThenMinimum() {
        double[] expected = {6.66, -45, 0.3, -0.3, 107.0, 15.0, 78.87};
        double[] actual = testSeries2.findTempsGreaterThen(testSeries2.min());
        Assert.assertArrayEquals(expected, actual, 0);
    }


    @Test
    public void testSummaryStatisticsMaxTemp() {
        double expected = 107;
        double actual = testSeries2.summaryStatistics().getMaxTemp();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testSummaryStatisticsMinTemp() {
        double expected = -45.0;
        double actual = testSeries2.summaryStatistics().getMinTemp();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testSummaryStatisticsAvgTemp() {
        double expected = 23.21857142857143;
        double actual = testSeries2.summaryStatistics().getAvgTemp();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testSummaryStatisticsDevTemp() {
        double expected = 48.09261613315096;
        double actual = testSeries2.summaryStatistics().getDevTemp();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testAddTemps1() {
        int expected = 8;
        int actual = testSeries1.addTemps(2, -9.7, 12, 19);
        assertEquals(expected, actual, 0);

    }

    @Test
    public void testAddTemps2() {
        int expected = 11;
        int actual = testSeries2.addTemps(2, -9.7, 12, 19);
        assertEquals(expected, actual, 0);

    }

    @Test
    public void testAddTemps3() {
        int expected = 2;
        int actual = testSeries3.addTemps(2);
        assertEquals(expected, actual, 0);

    }

    @Test
    public void testAddTemps4() {
        int expected = 7;
        int actual = testSeries4.addTemps(2, -9.7, 12, 19);
        assertEquals(expected, actual, 0);

    }
}
