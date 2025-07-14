import java.util.ArrayList;
import java.util.List;

class MorrisTraversal {
    public List<Integer> getMinimumDifference(TreeNode root) {
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;

            } else {
                TreeNode leftChild = curr.left;

                while (leftChild.right != null) {
                    leftChild = leftChild.right;
                }
                leftChild.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return list;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}