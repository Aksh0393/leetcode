import java.util.concurrent.atomic.AtomicInteger;

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
    AtomicInteger result = new AtomicInteger(0);

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result.get();
    }

    private Pair<Integer, Integer> solve(TreeNode root) {

        if (root == null)
            return new Pair<Integer, Integer>(0, 0);

        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);

        int leftSum = left.sum;
        int leftCount = left.count;

        int rightSum = right.sum;
        int rightCount = right.count;

        int totalSum = leftSum + rightSum + root.val;
        int totalCount = leftCount + rightCount + 1;

        if (totalSum / totalCount == root.val)
            result.incrementAndGet();

        return new Pair<Integer, Integer>(totalSum, totalCount);

    }
}

class Pair<U, V> {
    public final U sum;
    public final V count;

    Pair(U u, V v) {
        this.sum = u;
        this.count = v;
    }
}