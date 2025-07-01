class Solution {
    public int countVowelStrings(int n) {
        return combination(n + 4, 4);
    }

    // nCr
    private int combination(int n, int r) {
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return (int) res;
    }
}
