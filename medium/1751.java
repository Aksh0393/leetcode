import java.util.Arrays;
import java.util.Comparator;

class Solution {

    int memo[][];
    int nextIndex[];

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        nextIndex = new int[n];
        memo = new int[n + 1][k + 1];
        for (int i[] : memo)
            Arrays.fill(i, -1);
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (events[mid][0] <= events[i][1])
                    left = mid + 1;
                else
                    right = mid;
            }

            nextIndex[i] = left;
        }

        return recursion(events, 0, k);

    }

    private int recursion(int[][] events, int index, int k) {
        if (index >= events.length || k == 0)
            return 0;

        if (memo[index][k] != -1)
            return memo[index][k];

        int take = events[index][2] + recursion(events, nextIndex[index], k - 1);
        int notTake = recursion(events, index + 1, k);
        return memo[index][k] = Math.max(take, notTake);

    }

}