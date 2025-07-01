import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(1, n, ans, temp, k);
        return ans;
    }

    private void solve(int i, int n, List<List<Integer>> ans, List<Integer> temp, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i > n)
            return;
        temp.add(i);
        solve(i + 1, n, ans, temp, k - 1);
        temp.remove(temp.size() - 1);
        solve(i + 1, n, ans, temp, k);

    }
}