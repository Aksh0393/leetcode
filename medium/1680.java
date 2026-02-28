class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            int length = Integer.toBinaryString(i).length();
            ans = ((ans << length) | i) % MOD;
        }

        return (int) ans;
    }
}