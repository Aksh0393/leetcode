import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {

        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        char a[] = s.toCharArray();

        boolean used[] = new boolean[26];
        int lastIndex[] = new int[26];

        for (int i = 0; i < a.length; i++)
            lastIndex[a[i] - 'a'] = i;

        for (int i = 0; i < a.length; i++) {
            int idx = a[i] - 'a';

            if (used[idx])
                continue;

            while (!st.isEmpty() && st.peek() > a[i] && lastIndex[st.peek() - 'a'] > i)
                used[st.pop() - 'a'] = false;

            st.push(a[i]);
            used[a[i] - 'a'] = true;
        }

        while (!st.isEmpty())
            ans.append(st.pop());

        return ans.reverse().toString();
    }
}