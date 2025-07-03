import java.util.*;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int num : arr) {
            int prev = num - difference;
            int lenTillPrev = map.getOrDefault(prev, 0);
            int currLen = lenTillPrev + 1;
            map.put(num, currLen);
            result = Math.max(result, currLen);
        }

        return result;
    }
}
