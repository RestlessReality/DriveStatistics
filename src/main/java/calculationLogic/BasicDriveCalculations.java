package calculationLogic;

import dataTypes.PhasesOverThreshold;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * This class provides methods which do calculations on given Lists of speeds.
 */
public class BasicDriveCalculations {

    /**
     * Method returns the duration of the drive in seconds,
     * assuming that each speed was measured one second
     * after the predecessor.
     *
     * @param speeds A list containing the speeds from a drive.
     * @return The duration of the drive in seconds.
     */
    public int getDriveDurationInSeconds (List<Double> speeds){
        return speeds.size();
    }

    /**
     * Method returns the highest speed that was reached during the drive.
     *
     * @param speeds A list containing the speeds from a drive.
     * @return The highest speed during the drive
     */
    public Double getMaxSpeed (List<Double> speeds){
        return Collections.max(speeds);
    }

    /**
     * Method calculates the average speed from the given List of speeds.
     *
     * @param speeds A list containing the speeds from a drive.
     * @return The average speed, or null if the given List didn't contain values.
     */
    public Double getAverageSpeed (List<Double> speeds){
        if (CollectionUtils.isEmpty(speeds)){
            return null;
        }
        Double speedsSum = speeds.stream().mapToDouble( a -> a.doubleValue() ).sum();
        return speedsSum/speeds.size();
    }

    /**
     * Method counts driving phases with a speed over the given threshold and
     * sums up driving time with speed over threshold.
     *
     * @param speeds A list containing the speeds from a drive.
     * @param threshold The threshold value over which driving phases shall be counted
     * @return An {@link PhasesOverThreshold}-object, containing the number of driving phases with a speed over
     * the threshold and the total driving time over threshold-speed in minutes.
     */
    public PhasesOverThreshold getPhasesOverThreshold(List<Double> speeds, Double threshold){

        int countPhasesOverThreshold = 0;
        int timeOverThresholdInSeconds = 0;
        boolean possiblyNewPhase = true;

        for ( Double speed : speeds){

            if (speed > threshold){

                if (possiblyNewPhase) {
                    // Speed newly over threshold
                    countPhasesOverThreshold++;
                    timeOverThresholdInSeconds++;
                    possiblyNewPhase = false;
                }else{
                    // Speed still over threshold
                    timeOverThresholdInSeconds++;
                }

            }else{
                // Speed under threshold
                possiblyNewPhase = true;
            }
        }

        return new PhasesOverThreshold(countPhasesOverThreshold, timeOverThresholdInSeconds/60.0);

    }

}
