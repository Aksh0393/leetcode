import java.util.ArrayList;
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
// class Solution {
// public TreeNode replaceValueInTree(TreeNode root) {

// if (root == null)
// return root;

// Queue<TreeNode> q = new LinkedList<>();
// ArrayList<Integer> levelSum = new ArrayList<>();
// q.add(root);
// while (!q.isEmpty()) {
// int n = q.size();
// int currLevelSum = 0;
// while (n-- > 0) {

// TreeNode curr = q.poll();
// currLevelSum += curr.val;
// if (curr.left != null)
// q.add(curr.left);
// if (curr.right != null)
// q.add(curr.right);

// }
// levelSum.add(currLevelSum);
// }

// root.val = 0;
// q.add(root);
// int level = 1;
// while (!q.isEmpty()) {
// int n = q.size();
// while (n-- > 0) {

// TreeNode curr = q.poll();
// int leftSum = curr.left != null ? curr.left.val : 0;
// int rightSum = curr.right != null ? curr.right.val : 0;
// int siblingSum = leftSum + rightSum;

// if (curr.left != null) {
// curr.left.val = levelSum.get(level) - siblingSum;
// q.add(curr.left);
// }
// if (curr.right != null) {
// curr.right.val = levelSum.get(level) - siblingSum;
// q.add(curr.right);
// }
// }
// level++;
// }

// return root;
// }
// }

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {

        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelSum = root.val;

        while (!q.isEmpty()) {
            int n = q.size();
            int nextLevelSum = 0;
            while (n-- > 0) {
                TreeNode curr = q.poll();
                curr.val = levelSum - curr.val;
                int siblingSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    nextLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    nextLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    q.add(curr.right);
                }
            }

            levelSum = nextLevelSum;
        }

        return root;
    }
}