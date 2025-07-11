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
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        return bstToGst(root,new int[]{0});
    }

     public TreeNode bstToGst(TreeNode root,int a[]) {
        if(root == null)
         return root;

         bstToGst(root.right,a);
         a[0]+=root.val;

         root.val=a[0];
         bstToGst(root.left,a);

         return root;
    }
}