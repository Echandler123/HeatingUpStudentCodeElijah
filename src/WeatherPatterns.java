import java.util.ArrayList;

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
        int longest = 0;
        int currentTemp = 1;
        int size = temperatures.length;
        // Array to store the longest path from each index
        int[] longestPaths = new int[size];
        // Array of ArrayLists to store the indexes of the temperatures that are higher than the current temperature
        ArrayList<Integer>[] list = new ArrayList[size];
        // Initialize the ArrayLists
        for(int i = 0; i < size; i++){
           list[i] = new ArrayList<Integer>();
        }
        // Fill the ArrayLists with the indexes of the temperatures that are higher than the current temperature
        for(int i = 0; i < size; i++){
            currentTemp = temperatures[i];
            for(int j = i; j < size; j++){
                if(temperatures[j] > currentTemp){
                    list[i].add(j);
                }
            }
        }
        // Find the longest path from each index
        for(int i = 0; i < size; i++){
            longest = Math.max(longest, findLongest(list, i, longestPaths));
        }
        return longest;
    }
    public static int findLongest(ArrayList<Integer>[] list, int index, int[] paths){
        // If the path has already been calculated, return it
        if(paths[index] != 0){
            return paths[index];
        }
        int run = 0;
        // Find the longest path from the current index
        for(int i = 0; i < list[index].size(); i++){
            run = Math.max(run, findLongest(list, list[index].get(i), paths));
        }
        paths[index] = 1 + run;
        return paths[index];
    }
}

