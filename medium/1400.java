class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k)
            return false;
        if (n == k)
            return true;
        int freq[] = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int oddCount = 0;
        for (int f : freq)
            if ((f & 1) == 1)
                oddCount++;

        return oddCount <= k;

    }
}