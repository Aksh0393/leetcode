/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(null == root) return 0;
        int ans[] = new int[] { root.val };
        solve(root, ans);
        return ans[0];
    }

    private int solve(TreeNode root, int a[]) {
        if (null == root)
            return 0;

        int left = Math.max(solve(root.left, a), 0);
        int right = Math.max(solve(root.right, a), 0);

        int localMax = left + right + root.val;
        a[0] = Math.max(a[0], localMax);
        return Math.max(left, right) + root.val;
    }
}