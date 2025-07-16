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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int[] nums, int start, int end) {

        if (start > end)
            return null;

        int index = findMaxElementIndex(nums, start, end);

        TreeNode node = new TreeNode(nums[index]);
        node.left = solve(nums, start, index - 1);
        node.right = solve(nums, index + 1, end);
        return node;
    }

    private int findMaxElementIndex(int[] nums, int start, int end) {
        int max = nums[start];
        int index = start;

        for (int i = start; i <= end; i++)
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        return index;

    }

}