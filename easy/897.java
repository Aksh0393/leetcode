/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1); // Dummy node to build the result tree
        TreeNode curr = dummy;
        TreeNode node = root;

        while (node != null) {
            if (node.left == null) {
                // Visit node
                curr.right = new TreeNode(node.val);
                curr = curr.right;
                node = node.right;
            } else {
                // Find inorder predecessor
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Make thread
                    pred.right = node;
                    node = node.left;
                } else {
                    // Thread already exists - remove it
                    pred.right = null;

                    // Visit node
                    curr.right = new TreeNode(node.val);
                    curr = curr.right;

                    node = node.right;
                }
            }
        }

        return dummy.right;
    }
}
