class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        long minNegativeValueAbs = Long.MAX_VALUE;
        int negativeCount = 0;

        for (int row[] : matrix)
            for (int val : row) {
                totalSum += Math.abs(val);
                if (val < 0)
                    negativeCount++;
                minNegativeValueAbs = Math.min(minNegativeValueAbs, Math.abs(val));
            }

        if ((negativeCount & 1) != 0)
            totalSum -= 2 * minNegativeValueAbs;

        return totalSum;
    }
}