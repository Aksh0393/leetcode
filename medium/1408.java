import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {

        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && kmpHelper(words[i], words[j])) {
                    ans.add(words[i]);
                    break;
                }

        return ans;

    }

    private boolean kmpHelper(String pattern, String text) {

        int lps[] = kmp(pattern);
        int m = pattern.length();
        int n = text.length();
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                // result.add(i-j);
                // j = lps[j - 1];
                return true;
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }

        }
        return false;

    }

    private int[] kmp(String s) {
        int n = s.length();
        int lps[] = new int[n];
        int len = 0;
        int i = 1;
        char a[] = s.toCharArray();
        while (i < n) {
            if (a[i] == a[len]) {
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
        return lps;
    }
}