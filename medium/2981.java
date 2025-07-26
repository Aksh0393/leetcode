class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int dp[][] = new int[26][n + 1];
        char a[] = s.toCharArray();
        char prev = a[0];
        int len = 1;
        dp[prev - 'a'][len] = 1;
        for (int i = 1; i < n; i++) {

            if (prev == a[i]) {
                len++;
                dp[prev - 'a'][len] += 1;
            } else {
                len = 1;
                dp[a[i] - 'a'][len] += 1;
                prev = a[i];
            }
        }

        int res = -1;

        for (int i = 0; i < 26; i++) {
            int curr = 0;
            for (int j = n; j > 0; j--) {
                curr += dp[i][j];
                if (curr >= 3) {
                    res = Math.max(res, j);
                    break;
                }
            }
        }
        return res;
    }
}