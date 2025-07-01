import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(1, k, n, ans, temp);
        return ans;
    }

    private void solve(int val, int k, int target, List<List<Integer>> ans, List<Integer> temp) {

        if (target == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || temp.size() > k || val >= 10)
            return;

        for (int i = val; i < 10; i++) {
            temp.add(i);
            solve(i + 1, k, target - i, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}