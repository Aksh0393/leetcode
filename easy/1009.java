class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int countBits = 0;
        int num = n;
        while (num > 0) {
            countBits++;
            num = num >> 1;
        }

        int newVal = (int) Math.pow(2, countBits) - 1;
        return n ^ newVal;
    }
}