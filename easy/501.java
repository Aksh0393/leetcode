import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


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
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        TreeNode curr = root;
        while (curr != null) {

            if (curr.left == null) {

                int num = curr.val;
                if (num == currNum)
                    currStreak++;
                else {
                    currStreak = 1;
                    currNum = num;
                }

                if (currStreak > maxStreak) {
                    list = new ArrayList<>();
                    maxStreak = currStreak;
                }
                if (currStreak == maxStreak)
                    list.add(num);
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
            return list.stream().mapToInt(Integer::intValue).toArray();

    }
}