class Solution {
    public int longestSubstring(String s, int k) {

        int n = s.length();
        if (n == 0 || k > n)
            return 0;

        if (k <= 1)
            return n;

        int count[] = new int[26];
        for (int i : s.toCharArray())
            count[i - 'a']++;
        int i = 0;
        while (i < n && count[s.charAt(i) - 'a'] >= k)
            i++;

        if (i >= n - 1)
            return i;

        int left = longestSubstring(s.substring(0, i), k);
        while (i < n && count[s.charAt(i) - 'a'] < k)
            i++;

        int right = longestSubstring(s.substring(i), k);

        return Math.max(left, right);

    }
}