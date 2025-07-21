class Solution {
    public int findKthNumber(int n, int k) {

        int curr = 1;
        k--;
        while (k > 0) {

            int coount = countNums(curr, curr + 1, n);

            if (coount <= k) {
                curr++;
                k -= coount;
            } else {

                curr *= 10;
                k--;

            }
        }
        return curr;

    }

    private int countNums(long curr, long next, int n) {

        int count = 0;
        while (curr <= n) {
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }
}