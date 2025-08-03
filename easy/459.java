class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];

        // Build LPS array
        int len = 0;
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longestPrefixSuffix = lps[n - 1];

        return longestPrefixSuffix > 0 && (n % (n - longestPrefixSuffix) == 0);
    }
}
