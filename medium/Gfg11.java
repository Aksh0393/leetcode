// https://www.geeksforgeeks.org/problems/power-set4302/1

import java.util.*;

class Solution {
    private List<String> result = new ArrayList<>();

    private void solve(StringBuilder curr, String s, int idx) {
        if (idx == s.length()) {
            if (curr.length() > 0) {
                result.add(curr.toString());
            }
            return;
        }

        curr.append(s.charAt(idx));
        solve(curr, s, idx + 1);
        curr.deleteCharAt(curr.length() - 1);
        solve(curr, s, idx + 1);
    }

    public List<String> AllPossibleStrings(String s) {
        StringBuilder curr = new StringBuilder();

        solve(curr, s, 0);

        Collections.sort(result);

        return result;
    }
}