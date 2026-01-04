class Solution {
    public int numOfWays(int n) {
        // 121 131 212 232 313 323
        // 123 132 213 231 312 321
        // 121--> 212 232 313 312
        // 2*a121 , 2*123
        // 123--> 231 212 232 312 321
        // 2*a121 3*a123
        long mod = (long) 1e9 + 7;
        long a121 = 6, b123 = 6, a = 0, b;
        for (int i = 1; i < n; i++) {
            a = a121 * 2 + b123 * 2;
            b = a121 * 2 + b123 * 3;
            a121 = a % mod;
            b123 = b % mod;
        }
        return (int) ((a121 + b123) % mod);

    }
}