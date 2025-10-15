import java.util.List;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int currRun = 1;
        int prevRun = 0;
        int n = nums.size();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                currRun++;
            else {
                prevRun = currRun;
                currRun = 1;
            }

            ans = Math.max(ans, currRun/2);
            ans = Math.max(ans, Math.min(currRun, prevRun));


        }

        return ans;
    }
}