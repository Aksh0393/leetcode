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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;
        int currLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            currLevel++;
            int levelLength = queue.size();
            int currSum = 0;
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.remove();
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
                currSum += curr.val;

            }
            if (currSum > maxSum) {
                maxSum = currSum;
                maxSumLevel = currLevel;
            }
        }
        return maxSumLevel;
    }
}