package InterviewPrep.WePay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */

/**
 * The Alerter is a simple monitoring tool, intended to help detect increases in responses time for some process.
 * It does that by computing a few statistics about the process across a 'window' of a certain number of runs, and
 * alerting if certain thresholds are met.
 * <p>
 * It takes the following parameters:
 * inputs: A list of integer times for the process. This list may be very long.
 * window size: how many runs long a window is, as an integer
 * allowedIncrease: how far over 'average' a window or value, as a percent. This is represented as a decimal value
 * based on one, so a 50% allowable increase would be represented a 1.5
 */


public class Alerter {

    public boolean raiseAlert(int[] inputs, int windowSize, double allowedIncrease) {
        List<Double> avgVals = new ArrayList<>();
        boolean res = false;
        //  set a sliding window to check all windows
        for (int i = 0; i <= inputs.length - windowSize; i++) {
            int startIdx  = i;
            int endIdx = i + windowSize - 1;
            if (check(inputs, startIdx, endIdx, windowSize, allowedIncrease, avgVals)) {
                res = true;
            }
        }
        return res;
    }

    public boolean check(int[] inputs, int startIdx, int endIdx, int windowSize, double allowedIncrease, List<Double> avgVals) {
        int currWindSum = 0;
        double currWindAvg = 0;
        int currWindMax = Integer.MIN_VALUE;
        for (int i = startIdx; i <= endIdx; i++) {
            currWindSum += inputs[i];
            currWindMax = Math.max(currWindMax, inputs[i]);
        }
        currWindAvg = (double) currWindSum / windowSize;
        for (Double avgVal : avgVals) {
            // Current window average is more than allowed increase over one previous window average
            if (currWindAvg > avgVal * allowedIncrease) {
                return true;
            }
        }
        // Current window max is more than allowed increase over the current average value
        if (currWindMax > currWindAvg * allowedIncrease) {
            return true;
        }
        // Add current avg into avg list
        avgVals.add(currWindAvg);
        return false;
    }
}