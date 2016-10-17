package it.haskellis.drivestatistics.dataReceiving;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class reads the input from the user, converts and checks it.
 */
public class SpeedsReader {
    /**
     * Method collects Doubles from user and rejects anything else.
     * @return A list of the entered doubles.
     */
    public List<Double> getSpeedsFromUser() {
        System.out.println("Enter the speeds from the drive. End with empty line");

        Scanner scan = new Scanner(System.in);
        String newInput;
        Double nextDouble;
        List<Double> speeds = new ArrayList();
        boolean stop = false;

        while (!stop){
            newInput = scan.nextLine();

            if(StringUtils.isBlank(newInput)){
                System.out.println("You entered an empty line -> End of input.");
                stop = true;
            }else{
                // convert to double if possible
                try {
                    nextDouble = Double.valueOf(newInput);
                    speeds.add(nextDouble);
                }catch (NumberFormatException e){
                    System.out.println("You are only allowed to enter numbers. You didn't enter a well formed floating-point number. Exiting.");
                    stop = true;
                }
            }
        }
        return speeds;
    }

}
