/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Elijah Chandler
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        int longestRun = 0;
        int currentRun = 0;
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[i - 1]) {
                currentRun++;
            }
        }
        return currentRun;
    }
}
