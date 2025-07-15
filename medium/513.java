import java.util.LinkedList;
import java.util.Queue;

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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;
        int leftBottom = -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                TreeNode curr = q.poll();
                leftBottom = curr.val;
                if (curr.right != null)
                    q.add(curr.right);
                if (curr.left != null)
                    q.add(curr.left);
            }
        }
        return leftBottom;
    }
}