import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (int a[] : descriptions) {
            int p = a[0];
            int c = a[1];
            boolean isLeft = a[2] == 1;

            map.computeIfAbsent(p, k -> new TreeNode(p));
            map.computeIfAbsent(c, k -> new TreeNode(c));

            if (isLeft)
                map.get(p).left = map.get(c);
            else
                map.get(p).right = map.get(c);

            children.add(c);
        }

        for (Map.Entry<Integer, TreeNode> entry : map.entrySet())
            if (!children.contains(entry.getKey()))
                return entry.getValue();

        return null;
    }
}
