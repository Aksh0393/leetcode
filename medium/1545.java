class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';

        int length = (1 << n) - 1;

        if (k < (length + 2 - 1) / 2)
            return findKthBit(n - 1, k);

        if (k == (length + 2 - 1) / 2)
            return '1';

        char ch = findKthBit(n - 1, length - (k - 1));

        return ch == '0' ? '1' : '0';
    }
}