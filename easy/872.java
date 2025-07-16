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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        inorder(root1, s1);
        inorder(root2, s2);

        return s1.toString().equals(s2.toString());
    }

    private void inorder(TreeNode root, StringBuilder s) {
        if (root == null)
            return;
        if (root.right == null && root.left == null)
            s.append(root.val).append("#");

        inorder(root.left, s);
        inorder(root.right, s);
    }
}