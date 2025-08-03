class Solution {
    public long minimumSteps(String s) {

        long swaps = 0;
        long black = 0;

        for (char c : s.toCharArray()) {
            if (c == '0')
                swaps += black;
            else
                black++;
        }

        return swaps;
    }
}