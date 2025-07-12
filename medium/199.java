import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    ans.add(curr.val);
                if (curr.right != null)
                    q.add(curr.right);
                if (curr.left != null)
                    q.add(curr.left);
            }
        }
        return ans;
    }
}