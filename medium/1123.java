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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return null;
        return solve(root).node;
    }

    private Pair solve(TreeNode root) {
        if (root == null)
            return new Pair(0, root);

        Pair l = solve(root.left);
        Pair r = solve(root.right);

        if (l.depth == r.depth)
            return new Pair(l.depth + 1, root);

        else if (l.depth > r.depth)
            return new Pair(l.depth + 1, l.node);

        else
            return new Pair(r.depth + 1, r.node);

    }
}

class Pair {
    int depth;
    TreeNode node;

    Pair(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}
