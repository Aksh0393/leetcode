class Solution {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null) {
            if (curr.left == null) {
                if (prev != null) {
                    min = Math.min(min, Math.abs(curr.val - prev.val));
                }
                prev = curr;
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

        return min;
    }
}
