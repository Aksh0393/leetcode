import java.util.HashMap;

class Solution {

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> yValues = new HashMap<>();
        int mod = 1_000_000_007;
        long trapezoids = 0;
        long prevLines = 0;
        for (int point[] : points) {
            int y = point[1];
            yValues.put(y, yValues.getOrDefault(y, 0) + 1);
        }

        for (int currPoints : yValues.values()) {

            long currLines = (long) currPoints * (currPoints - 1) / 2;
            trapezoids = (trapezoids + (prevLines * currLines) % mod) % mod;
            prevLines += currLines;
        }

        return (int) (trapezoids % mod);

    }
}