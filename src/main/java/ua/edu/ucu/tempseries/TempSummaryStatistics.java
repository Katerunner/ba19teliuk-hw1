package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public TempSummaryStatistics(double avgTemp1,
                                 double devTemp1,
                                 double minTemp1,
                                 double maxTemp1) {
        this.maxTemp = maxTemp1;
        this.avgTemp = avgTemp1;
        this.devTemp = devTemp1;
        this.minTemp = minTemp1;
    }

    public double getMaxTemp() {
        return this.maxTemp;
    }

    public double getAvgTemp() {
        return this.avgTemp;
    }

    public double getDevTemp() {
        return this.devTemp;
    }

    public double getMinTemp() {
        return this.minTemp;
    }
}
