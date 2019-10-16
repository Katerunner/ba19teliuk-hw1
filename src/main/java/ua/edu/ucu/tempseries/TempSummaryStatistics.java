package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private static double avgTemp;
    private static double devTemp;
    private static double minTemp;
    private static double maxTemp;

    public TempSummaryStatistics(double avgTemp,
                                 double devTemp,
                                 double minTemp,
                                 double maxTemp) {
        this.maxTemp = maxTemp;
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }
}
