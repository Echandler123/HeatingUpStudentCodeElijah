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
        int current = 1;
        int size = temperatures.length;
        int[] paths = new int[size];
        ArrayList<Integer>[] list = new ArrayList[size];
        for(int i = 0; i < size; i++){
           list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < size; i++){
            current = temperatures[i];
            for(int j = i; j < size; j++){
                if(temperatures[j] > current){
                    list[i].add(temperatures[j]);
                }
            }
        }
        for(int i = 0; i < size; i++){
            longest = findLongest(list, i, paths);
        }
        return longest;
    }
    public static int findLongest(ArrayList<Integer>[] list, int index, int[] paths){
        if(paths[index] != 0){
            return paths[index];
        }
        int run = 0;
        for(int i = 0; i < list[index].size(); i++){
            run = Math.max(run, findLongest(list, list[index].get(i), paths));
        }
        paths[index] = 1 + run;
        return paths[index];
       /*
       LongestPathTo(Vertex V):
	        len = 0;
            For each vertex V' leading to V:
		        len = Max( len,  LongestPathTo(V'))
                return 1 + len;
         */
          /*
       Idea: let's keep track of the longest paths for each node in an array.
      During our recursive step: before recursing, check to see if
      we have been to that node already. If so, use its saved value.
      If we have never been there before, then recurse.
      When done recursing, add its new value to our array.
        */

    }
}

