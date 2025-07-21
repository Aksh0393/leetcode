class Solution {
    public int kthGrammar(int n, int k) {
        // 0
        // 01
        // 0110
        // 01101001
        // 0110100110010110

        if (n == 1 && k == 1)
            return 0;

        int mid = (1 << (n - 1)) / 2;

        if (k <= mid)
            return kthGrammar(n - 1, k);

        else
            return 1 - kthGrammar(n - 1, k - mid);
    }
}