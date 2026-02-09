import java.util.*;

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
    public TreeNode balanceBST(TreeNode root) {

        List<Integer> morris = new ArrayList<>();

        TreeNode curr = root;

        while (curr!=null) {

            if(curr.left ==null)
            {
                morris.add(curr.val);
                curr = curr.right;
            }

            else{
                TreeNode leftChild = curr.left;
                while (leftChild.right!=null) {
                    leftChild = leftChild.right;
                }

                leftChild.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left =null;
            }
        }

        return build(morris,0,morris.size()-1);
    }

    private TreeNode build(List<Integer> morris, int i, int j) {

        if(i>j) return null;
        if(i==j) return new TreeNode(morris.get(i));

        int mid = (i+j)/2;
        TreeNode root = new TreeNode(morris.get(mid));

        root.left = build(morris, i, mid-1);
        root.right = build(morris,  mid+1,j);
        return root;

    }
}