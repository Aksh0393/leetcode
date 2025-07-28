class Solution {
    public int minSteps(String s, String t) {

        char a[] = s.toCharArray();
        char b[] = t.toCharArray();
        int freq[] = new int[26];
        int moves = 0;
        for (int i = 0; i < a.length; i++) {
            freq[a[i] - 'a']++;
            freq[b[i] - 'a']--;
        }

        for (int i : freq)
            moves += Math.max(0, i);

        return moves;
    }
}