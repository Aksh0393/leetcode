class Solution {

    public static long count(long k, int rigthmost, int x) {
        if (k < rigthmost)
            return 0;

        long n = 1, bits = rigthmost, p = 1;
        while (2 * bits + (p % x == 0 ? n : 0) <= k) {
            bits = 2 * bits + (p % x == 0 ? n : 0);
            n *= 2;
            ++p;
        }

        return n + count(k - bits, rigthmost + (p % x == 0 ? 1 : 0), x);
    }

    public static long findMaximumNumber(long k, int x) {
        return count(k, 0, x) - 1;
    }

}
