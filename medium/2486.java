class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0; // s
        int j = 0; // t;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j))
                j++;

            i++;
        }

        return n - j;
    }
}