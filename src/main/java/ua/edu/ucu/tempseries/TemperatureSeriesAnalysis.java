package ua.edu.ucu.tempseries;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    public static final int MIN_TEMPERATURE = -273;
    private double[] temperatureSeries;
    
    public TemperatureSeriesAnalysis(double[] tempSeries) {
        int newLen = tempSeries.length;
        double[] array = Arrays.copyOf(tempSeries, newLen);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < MIN_TEMPERATURE) {
                throw new InputMismatchException();
            }
        }
        temperatureSeries = array;
    }

    public void noElements() {
        if (temperatureSeries.length <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public double average() {
        noElements();
        double sum = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            sum = sum + temperatureSeries[i];
        }

        return sum / temperatureSeries.length;
    }

    public double deviation() {
        noElements();
        double dev = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            dev += (temperatureSeries[i] - average())
                * (temperatureSeries[i] - average());
        }
        return Math.sqrt(dev / temperatureSeries.length);
    }

    public double min() {
        noElements();
        double minn = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < minn) {
                minn = temperatureSeries[i];
            }
        }
        return minn;
    }

    public double max() {
        noElements();
        double maxx = temperatureSeries[0];
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] > maxx) {
                maxx = temperatureSeries[i];
            }
        }
        return maxx;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        noElements();
        double diff = temperatureSeries[0] - tempValue;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < Math.abs(diff)) {
                diff = temperatureSeries[i];
            }
        }
        return diff;
    }

    public double[] findTempsLessThen(double tempValue) {
        noElements();
        int newlen = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                newlen += 1;
            }
        }
        double[] result = new double[newlen];
        int j = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < tempValue) {
                result[j] = temperatureSeries[i];
                j += 1;
            }
        }
        return result;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        noElements();
        int newlen = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] >= tempValue) {
                newlen += 1;
            }
        }
        double[] result = new double[newlen];
        int j = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] >= tempValue) {
                result[j] = temperatureSeries[i];
                j += 1;
            }
        }
        return result;
    }

    public TempSummaryStatistics summaryStatistics() {
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.min();
        double maxTemp = this.max();

        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps) {
        int newLen = temperatureSeries.length * 2;
        double[] newArr = new double[temperatureSeries.length + newLen];
        int i;
        int numberValues = 0;
        for (i = 0; i < temperatureSeries.length; i++) {
            newArr[i] = temperatureSeries[i];
            numberValues++;
        }
        for (int j = 0; j < temps.length; j++) {
            newArr[i + j] = temps[j];
            numberValues++;
        }
        this.temperatureSeries = newArr;
        return numberValues;
    }
}
