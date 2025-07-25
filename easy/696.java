class Solution {
    public int countBinarySubstrings(String s) {

        int n = s.length();
        int curr = 1;
        int prev = 0;
        int ans = 0;
        char a[] = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            } else
                curr++;
        }
        ans += Math.min(prev, curr);
        return ans;
    }
}