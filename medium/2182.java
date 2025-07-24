class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        int freq[] = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int pointer = 25; // Start from 'z'
        while (pointer >= 0) {

            if (freq[pointer] == 0) {
                pointer--;
                continue;
            }

            int limit = Math.min(freq[pointer], repeatLimit);

            for (int i = 0; i < limit; i++)
                result.append((char) ('a' + pointer));

            freq[pointer] -= limit;

            if (freq[pointer] > 0) {
                int prevPointer = pointer - 1;
                while (prevPointer >= 0 && freq[prevPointer] == 0)
                    prevPointer--;

                if (prevPointer < 0)
                    break;
                result.append((char) ('a' + prevPointer));
                freq[prevPointer]--;
            }

        }
        return result.toString();
    }
}