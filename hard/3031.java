class Solution {
    public int minimumTimeToInitialState(String word, int k) {

        int lps[] = LPS(word);
        int n = word.length();
        int maxLen = lps[n - 1];

        while (maxLen > 0 && (n - maxLen) % k != 0)
            maxLen = lps[maxLen - 1];

        if((n-maxLen)%k==0)
        return (n-maxLen)/k;

        return (n+k-1)/k;

    }

    private int[] LPS(String word) {

        char a[] = word.toCharArray();
        int n = a.length;
        int lps[] = new int[n];

        int len = 0;
        lps[0] = 0;
        int i = 1;

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