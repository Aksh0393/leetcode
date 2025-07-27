class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        char a[] = str1.toCharArray();
        char b[] = str2.toCharArray();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (a[i] == b[j] || a[i] + 1 == b[j] || a[i] - 25 == b[j]) {
                i++;
                j++;
            } else
                i++;
        }

        return j == n;
    }
}