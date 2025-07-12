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
    public int findTilt(TreeNode root) {
        int ans[] = new int[1];
        ans[0] = 0;
        if (root == null)
            return 0;

        solve(root, ans);
        return ans[0];
    }

    private int solve(TreeNode root, int a[]) {
        if (root == null)
            return 0;

        int left = solve(root.left, a);
        int right = solve(root.right, a);

        a[0] += Math.abs(right - left);
        return left + right + root.val;
    }
}