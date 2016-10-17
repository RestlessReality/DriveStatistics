package it.haskellis.drivestatistics;

import it.haskellis.drivestatistics.calculationLogic.BasicDriveCalculations;
import it.haskellis.drivestatistics.dataReceiving.SpeedsReader;
import it.haskellis.drivestatistics.dataTypes.PhasesOverThreshold;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Main class
 * Todo unit-tests
 * ToDo Assumption: First speed is after 1 second, not at 0 seconds.
 */
public class Main {

   public static void main (String[] args){

       SpeedsReader speedsReader = new SpeedsReader();
       List<Double> speeds = speedsReader.getSpeedsFromUser();

       if(CollectionUtils.isNotEmpty(speeds)) {
           //output drive statistics
           System.out.println("Statistics of your drive:");
           System.out.println("Your speeds: " + speeds.toString());
           BasicDriveCalculations calculator = new BasicDriveCalculations();
           System.out.println("Duration of the drive: " + calculator.getDriveDurationInSeconds(speeds) + " seconds.");
           System.out.println("Maximal speed during the drive: " + calculator.getMaxSpeed(speeds));
           System.out.println("Average speed: " + calculator.getAverageSpeed(speeds));
           PhasesOverThreshold phasesOverThreshold = calculator.getPhasesOverThreshold(speeds, 100.0);
           System.out.println("Driving time over 100 km/h in minutes: " + phasesOverThreshold.getTimeOverThreshold());
           System.out.println("Number of driving-phases over 100 km/h: " + phasesOverThreshold.getCountPhasesOverThreshold());
       }

   }

}
