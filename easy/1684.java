class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;

        for (char ch : allowed.toCharArray())
            mask |= 1 << (ch - 'a');

        int count = 0;
        for (String word : words) {
            boolean allCharAllowed = true;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (((mask >> (ch - 'a')) & 1) == 0) {
                    allCharAllowed = false;
                    break;
                }
            }

            if (allCharAllowed)
                count++;

        }

        return count;
    }
}
