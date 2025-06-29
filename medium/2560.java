import java.util.Arrays;

class Solution {
    public int minCapability(int[] nums, int k) {
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (l <= r) {
            int capability = l + (r - l) / 2;
            if (isPossible(nums, k, capability)) {
                ans = capability;
                r = capability - 1;
            } else
                l = capability + 1;
        }
        return ans;
    }

    private boolean isPossible(int a[], int k, int capability) {
        int houses = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= capability) {
                houses++;
                i++;
            }
        }
        return houses >= k;
    }
}