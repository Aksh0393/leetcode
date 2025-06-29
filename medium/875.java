import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = 0;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (isPossible(piles, h, mid)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;

        }
        return ans;
    }

    private boolean isPossible(int[] piles, int h, int speed) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {
            int val = piles[i];
            hours += (val + speed - 1) / speed;

            if (hours > h)
                return false;
        }
        return true;
    }
}