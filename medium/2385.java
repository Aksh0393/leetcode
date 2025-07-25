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
    private int result = Integer.MAX_VALUE;

    public int amountOfTime(TreeNode root, int start) {
        solve(root, start);
        return result;
    }

    private int solve(TreeNode root, int start) {
        if (root == null)
            return 0;

        int lh = solve(root.left, start);
        int rh = solve(root.right, start);

        if (root.val == start) {
            result = Math.max(lh, rh);
            return -1;
        }

        else if (lh >= 0 && rh >= 0) {
            int d = Math.max(lh, rh) + 1;
            return d;
        } else {
            int d = Math.abs(lh) + Math.abs(rh);
            result = Math.max(result, d);
            return Math.min(lh, rh) - 1;
        }

    }
}