import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
class Gfg5 {
    List<Node> list = new ArrayList<>();
    Set<Node> ans = new HashSet<>();

    int printKDistantfromLeaf(Node root, int k) {
        solve(root, k, 0);
        return ans.size();
    }

    private void solve(Node root, int k, int level) {
        if (root == null)
            return;

        // Add current node to the path
        list.add(root);

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            if (level - k >= 0) {
                ans.add(list.get(level - k));
            }
        }

        // Continue DFS
        solve(root.left, k, level + 1);
        solve(root.right, k, level + 1);

        // Backtrack: remove current node
        list.remove(list.size() - 1);
    }
}
