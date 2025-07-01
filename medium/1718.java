import java.util.BitSet;

class Solution {
    private int n, az;
    private BitSet vis;
    private int[] ans;

    public int[] constructDistancedSequence(int n) {

        this.n = n;
        this.az = 2 * n - 1;
        vis = new BitSet(n + 1);
        ans = new int[az];
        dfs(0);
        return ans;
    }

    private boolean dfs(int idx) {
        if (idx == az)
            return vis.cardinality() == n;
        if (ans[idx] != 0)
            return dfs(idx + 1);

        for (int val = n; val >= 1; val--) {
            if (vis.get(val))
                continue;
            int nextIdx = val > 1 ? idx + val : idx;
            if (nextIdx >= az || ans[nextIdx] != 0)
                continue;
            ans[idx] = ans[nextIdx] = val;
            vis.set(val);
            if (dfs(idx + 1))
                return true;
            ans[idx] = ans[nextIdx] = 0;
            vis.clear(val);

        }
        return false;

    }
}