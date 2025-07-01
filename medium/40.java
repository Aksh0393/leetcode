import java.util.*;

class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    void helper(int a[], int target, int i, ArrayList<Integer> temp) {

        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int start = i; start < a.length; start++) {
            if (a[i] > target)
                return;
            if (start > i && a[start] == a[start - 1])
                continue;

            temp.add(a[start]);
            helper(a, target - a[start], start + 1, temp);
            temp.remove(temp.size() - 1);

        }
    }
}