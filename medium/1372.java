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
    public int longestZigZag(TreeNode root) {

        if (root == null)
            return 0;
        int a[] = new int[1];
        solve(root, 0, 0, a);
        return a[0];
    }

    private void solve(TreeNode root, int l, int r, int[] a) {

        if (root == null)
            return;

        a[0] = Math.max(a[0], Math.max(l, r));

        solve(root.left, r+1, 0, a);
        solve(root.right, 0, l+1, a);
    }
}