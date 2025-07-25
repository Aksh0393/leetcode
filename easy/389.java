
class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0;

        for (char ch : t.toCharArray())
            xor ^= ch;

        for (char ch : s.toCharArray())
            xor ^= ch;

        return (char) xor;
    }
}