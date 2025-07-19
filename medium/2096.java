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
    public String getDirections(TreeNode root, int startValue, int destValue) {

        StringBuilder rootToStart = new StringBuilder();
        StringBuilder rootToDest = new StringBuilder();

        solve(root, startValue, rootToStart);
        solve(root, destValue, rootToDest);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < rootToDest.length() && i < rootToStart.length() && rootToDest.charAt(i) == rootToStart.charAt(i))
            i++;

        for (int j = i; j < rootToStart.length(); j++)
            ans.append("U");
        for (int j = i; j < rootToDest.length(); j++)
            ans.append(rootToDest.charAt(j));

        return ans.toString();

    }

    private boolean solve(TreeNode root, int target, StringBuilder s) {

        if (root == null)
            return false;

        if (root.val == target)
            return true;

        s.append("L");
        if (solve(root.left, target, s))
            return true;

        s.deleteCharAt(s.length() - 1);

        s.append("R");
        if (solve(root.right, target, s))
            return true;
        s.deleteCharAt(s.length() - 1);

        return false;

    }
}