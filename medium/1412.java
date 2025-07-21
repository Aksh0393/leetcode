class Solution {
    public int findTheWinner(int n, int k) {
        int idx = solve(n, k);
        return idx + 1;
    }

    private int solve(int n, int k) {
        if (n == 1)
            return 0;

        int idx = solve(n - 1, k);
        idx = (idx + k) % n;
        return idx;
    }

}