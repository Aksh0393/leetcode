class Solution {
    public int largestCombination(int[] candidates) {
        int setBits = 0;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            setBits = 0;
            for (int num : candidates)
                if ((num & (1 << i)) != 0)
                    setBits++;
            res = Math.max(res, setBits);
        }
        return res;
    }
}