class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        int times[] = new int[n];
        for (int i = 0; i < n; i++)
            max = Math.max(max, solve(n, headID, manager, informTime, times, i));

        return max;
    }

    private int solve(int n, int headID, int[] manager, int[] informTime, int times[], int curr) {

        if (curr == headID)
            return 0;

        if (times[curr] != 0)
            return times[curr];

        int parent = manager[curr];
        return times[curr] = informTime[parent] + solve(parent, headID, manager, informTime, times, parent);
    }
}