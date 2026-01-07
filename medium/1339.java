import java.util.*;

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
    private int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {

        long totalSum = 0;
        AtomicLong maxP = new AtomicLong(0);
        totalSum = solve(root);
        solve2(root, maxP, totalSum);
        return (int) (maxP.get() % MOD);

    }

    private long solve(TreeNode root) {
        if (root == null)
            return 0;

        long leftSum = solve(root.left);
        long rightSum = solve(root.right);

        long currSum = leftSum + root.val + rightSum;
        return currSum;
    }

    private long solve2(TreeNode root, AtomicLong maxP, long totalSum) {
        if (root == null)
            return 0;
        long leftSum = solve2(root.left, maxP, totalSum);
        long rightSum = solve2(root.right, maxP, totalSum);

        long s1 = leftSum + root.val + rightSum;
        long s2 = totalSum - s1;
        long product = s1 * s2;
        maxP.set(Math.max(maxP.get(), product));
        return s1;
    }
}