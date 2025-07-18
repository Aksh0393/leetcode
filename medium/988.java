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
    public String smallestFromLeaf(TreeNode root) {
        String ans[] = new String[1];
        ans[0] = "";
        solve(root, "", ans);
        return ans[0];
    }

    private void solve(TreeNode root, String curr, String[] ans) {

        if (root == null)
            return;

        curr = (char) (root.val + 'a') + curr;
        if (root.left == null && root.right == null) {
            if (ans[0].equals("") || ans[0].compareTo(curr) > 0)
                ans[0] = curr;
        }

        solve(root.left, curr, ans);
        solve(root.right, curr, ans);
    }

}