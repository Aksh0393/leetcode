class Solution {
    public String shortestPalindrome(String s) {
        // abaxz
        // zxaba
        // zxababaxz
        StringBuilder str = new StringBuilder(s);
        String rev = new StringBuilder(s).reverse().toString();
        str.append("%&$");

        str.append(rev);
        char a[] = str.toString().toCharArray();
        int n = a.length;
        int lps[] = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;

        while (i < n) {

            if (a[i] == a[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0)
                    len = lps[len - 1];

                else {
                    lps[i] = 0;
                    i++;
                }
            }

        }

        int lpsLen = lps[n-1];
        String culprit = rev.substring(0, s.length() -  lpsLen);

        return culprit + s;


    }
}