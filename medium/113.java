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
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        sol(ans, new ArrayList<Integer>(), targetSum, root);
        return ans;
    }

    public void sol(List<List<Integer>> ans, ArrayList<Integer> temp, int targetSum, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && root.val == targetSum) {
            temp.add(root.val);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        sol(ans, temp, targetSum - root.val, root.left);
        sol(ans, temp, targetSum - root.val, root.right);
        temp.remove(temp.size() - 1);

    }
}