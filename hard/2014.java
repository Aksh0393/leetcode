import java.util.*;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int freq[] = new int[26];
        for (char i : s.toCharArray())
            freq[i - 'a']++;

        List<Character> list = new ArrayList<>();

        for (int i = 25; i >= 0; i--)
            if (freq[i] >= k)
                list.add((char) (i + 'a'));

        Queue<String> q = new LinkedList<>();
        for (char i : list)
            q.add(String.valueOf(i));
        String ans = "";

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.length() > ans.length()) {
                ans = curr;
            }
            for (char c : list) {
                String next = curr + c;
                System.out.println(next);
                if (isKRepeatedSubsequence(s, next, k)) {
                    q.add(next);
                }

            }
        }
        return ans;
    }

    private boolean isKRepeatedSubsequence(String s, String t, int k) {
        int count = 0;
        int i = 0;
        int n = t.length();
        int pos = 0;
        for (char ch : s.toCharArray()) {
            if (ch == t.charAt(pos)) {
                pos++;
                if (pos == n) {
                    pos = 0;
                    count++;
                    if (count == k)
                        return true;
                }
            }
        }
        return false;
    }
}