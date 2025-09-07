class Solution {
    public int[] sumZero(int n) {

        int a[] = new int[n];
        int i = 0;
        while (i < n / 2) {
            a[i] = -(i + 1);
            a[n - i - 1] = i + 1;
            i++;
        }
        return a;
    }
}