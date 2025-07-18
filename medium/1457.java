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
    public int pseudoPalindromicPaths(TreeNode root) {
        int count[] = new int[1];
        solve(root, 0, count);
        return count[0];
    }

    private void solve(TreeNode root, int mask, int[] count) {

        if (root == null)
            return;

        mask = mask ^ (1 << root.val);

        if (root.left == null && root.right == null) {
            if ((mask & mask - 1) == 0)
                count[0]++;
            return;
        }

        solve(root.right, mask, count);
        solve(root.left, mask, count);

    }
}