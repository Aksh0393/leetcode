import java.util.*;

class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> vaList = new ArrayList<>();

        for (String i : arr) {
            HashSet<Character> set = new HashSet<>();
            for (char c : i.toCharArray())
                set.add(c);

            if (set.size() != i.length())
                continue;

            int val = 0;
            for (char c : set)
                val = val | (1 << (c - '0'));
            vaList.add(val);

        }
        int res[] = { 0 };

        dfs(0, 0, res, vaList);

        return res[0];
    }

    private void dfs(int index, int temp, int result[], List<Integer> vaList) {

        result[0] = Math.max(result[0], Integer.bitCount(temp));
        for (int i = index; i < vaList.size(); i++)
            if ((temp & vaList.get(i)) == 0)
                dfs(i + 1, temp | vaList.get(i), result, vaList);

    }

}
