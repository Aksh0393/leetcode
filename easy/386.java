import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            if (i > n)
                break;
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int curr, int limit, List<Integer> list) {
        if (curr > limit)
            return;

        list.add(curr);
        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > limit)
                break;

            dfs(next, limit, list);
        }
    }
}