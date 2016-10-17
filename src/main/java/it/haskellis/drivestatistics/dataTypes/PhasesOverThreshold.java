package it.haskellis.drivestatistics.dataTypes;

/**
 * DataType class for the time in and number of driving-phases with a speed over a threshold
 */
public class PhasesOverThreshold {
    final int countPhasesOverThreshold;
    final double timeOverThresholdInMinutes;

    public PhasesOverThreshold(int countPhasesOverThreshold, double timeOverThreshold) {
        this.countPhasesOverThreshold = countPhasesOverThreshold;
        this.timeOverThresholdInMinutes = timeOverThreshold;
    }

    public int getCountPhasesOverThreshold() {
        return countPhasesOverThreshold;
    }

    public double getTimeOverThreshold() {
        return timeOverThresholdInMinutes;
    }
}
