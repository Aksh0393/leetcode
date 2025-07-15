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
    public boolean isEvenOddTree(TreeNode root) {

        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEven = true;

        while (!q.isEmpty()) {
            int n = q.size();
            int prev = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (n-- > 0) {
                TreeNode curr = q.poll();
                if (isEven) {
                    if (curr.val % 2 == 0 || prev >= curr.val)
                        return false;
                } else if (curr.val % 2 == 1 || prev <= curr.val)
                    return false;

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

                prev = curr.val ;
            }

            isEven = !isEven;
        }

        return true;
    }
}