class Solution {
    public boolean isPowerOfThree(int n) {
        int e = (int)(Math.log(Integer.MAX_VALUE) / Math.log(3));
        int N = (int)Math.pow(3, e);
        return n > 0 && N % n == 0;
    }
}