import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>(); // lake -> last day it was filled
        TreeSet<Integer> dryDays = new TreeSet<>(); // days when it didn't rain
        Arrays.fill(result, -1); // default value for dry days

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0)
                dryDays.add(i);  // potential dry day
            else {
                result[i] = -1; // it rained this day
                // if lake is already full, we need to find a dry day after lastRainDay
                if (map.containsKey(lake)) {
                    int lastRainDay = map.get(lake).intValue(); // last day it rained on this lake
                    Integer dryDay = dryDays.higher(lastRainDay); // find a dry day after lastRainDay
                    if (dryDay == null) // no dry day available to prevent flood
                        return new int[0];
                    result[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                map.put(lake, i); // update last rain day for this lake
            }
        }
        return result;
    }
}
