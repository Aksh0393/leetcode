import java.util.BitSet;
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
class FindElements {

    BitSet recordValues;

    public FindElements(TreeNode root) {
        recordValues = new BitSet();
        recovertree(root);
    }

    public boolean find(int target) {
        return recordValues.get(target);
    }

    private void recovertree(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int x = curr.val;
            recordValues.set(x);

            if (curr.left != null) {
                curr.left.val = 2 * x + 1;
                q.add(curr.left);
            }
            if (curr.right != null) {
                curr.right.val = 2 * x + 2;
                q.add(curr.right);
            }
        }

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */