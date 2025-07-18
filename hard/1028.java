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
    public TreeNode recoverFromPreorder(String traversal) {

        AtomicInteger i = new AtomicInteger(0);
        return solve(traversal.toCharArray(), i, traversal.length(), 0);
    }

    private TreeNode solve(char a[], AtomicInteger i, int n, int depth) {

        if (i.get() >= n)
            return null;

        int j = i.get();

        while (j < n && a[j] == '-')
            j++;

        int dash = j - i.get();

        if (dash != depth)
            return null;

        i.set(j);

        int val = 0;

        j = i.get();

        while (j < n && Character.isDigit(a[j]))
            val = val * 10 + (a[j++] - '0');

        i.set(j);

        TreeNode node = new TreeNode(val);

        node.left = solve(a, i, n, depth + 1);
        node.right = solve(a, i, n, depth + 1);

        return node;

    }
}