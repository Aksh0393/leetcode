class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = { -1, -1 };
        ans[0] = bs(nums, target, true);
        if (ans[0] != -1)
            ans[1] = bs(nums, target, false);
        return ans;

    }

    private int bs(int a[], int t, boolean isFirstRequired) {
        int l = 0;
        int h = a.length - 1;
        int i = -1;

        while (l <= h) {
            int mid = (h + l) / 2;
            if (a[mid] > t)
                h = mid - 1;
            else if (a[mid] < t)
                l = mid + 1;
            else {
                i = mid;
                if (isFirstRequired)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return i;
    }
}