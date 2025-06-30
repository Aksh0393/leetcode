class Solution {
    public int findKthPositive(int[] a, int k) {

        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] - (mid + 1) < k)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l + k;
    }
}