import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        
        // Instead of bitset<26>, we use boolean arrays
        boolean[][] pre = new boolean[n][26];
        boolean[][] suf = new boolean[n][26];

        // Build prefix and suffix frequency bit masks
        for (int l = 0, r = n - 1; l < n; l++, r--) {
            pre[l][s.charAt(l) - 'a'] = true;
            suf[r][s.charAt(r) - 'a'] = true;

            if (l > 0) {
                for (int i = 0; i < 26; i++) {
                    pre[l][i] |= pre[l - 1][i];
                }
            }

            if (r < n - 1) {
                for (int i = 0; i < 26; i++) {
                    suf[r][i] |= suf[r + 1][i];
                }
            }
        }

        int result = 0;

        // seen[in][out] ensures we count each unique pair only once
        boolean[][] seen = new boolean[26][26];

        for (int mid = 1; mid < n - 1; mid++) {
            int in = s.charAt(mid) - 'a';

            for (int out = 0; out < 26; out++) {
                if (pre[mid - 1][out] && suf[mid + 1][out] && !seen[in][out]) {
                    result++;
                    seen[in][out] = true;
                }
            }
        }

        return result;
    }
}
