
class Solution {
    public int strStr(String haystack, String needle) {

        int lps[] = computeLPS(needle);

        int i = 0; // hay
        int j = 0; // needle

        int m = haystack.length();
        int n = needle.length();
        char a[] = haystack.toCharArray();
        char b[] = needle.toCharArray();

        while (i < m) {

            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == n)
                return i - j;
            else if ( i<m && j < n && a[i] != b[j]) {
                if (j > 0)
                    j = lps[j - 1];
                else
                    i++;

            }
        }
        return -1;

    }

    private int[] computeLPS(String needle) {
        int n = needle.length();
        int lps[] = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        char a[] = needle.toCharArray();
        while (i < n) {

            if (a[i] == a[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;

                }
            }

        }

        return lps;

    }
}