import java.util.ArrayList;
import java.util.HashMap;
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        dfs(list, map, root);
        return list;
    }

    private String dfs(List<TreeNode> list, HashMap<String, Integer> map, TreeNode root) {

        if (root == null)
            return "#";

        String path = new StringBuilder()
                .append(root.val)
                .append(",")
                .append(dfs(list, map, root.left))
                .append(",")
                .append(dfs(list, map, root.right)).toString();

        if(map.containsKey(path) && map.get(path).intValue() ==1)
        list.add(root);
        map.put(path, map.getOrDefault(path, 0)+1);

        return path;
    }
}