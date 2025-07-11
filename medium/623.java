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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        return helper(root, val, depth, 1);
    }

    private TreeNode helper(TreeNode root, int val, int depth, int currDepth) {

        if (null == root)
            return root;

        if (currDepth == depth - 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = new TreeNode(val);
            root.left = new TreeNode(val);

            root.left.left = left;
            root.right.right = right;
            return root;
        }

        root.left = helper(root.left, val, depth, currDepth + 1);
        root.right = helper(root.right, val, depth, currDepth + 1);

        return root;
    }
}