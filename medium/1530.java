import java.util.*;

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  * int val;
//  * TreeNode left;
//  * TreeNode right;
//  * TreeNode() {}
//  * TreeNode(int val) { this.val = val; }
//  * TreeNode(int val, TreeNode left, TreeNode right) {
//  * this.val = val;
//  * this.left = left;
//  * this.right = right;
//  * }
//  * }
//  */
// class Solution {
//     public int countPairs(TreeNode root, int distance) {

//         HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
//         Set<TreeNode> leafs = new HashSet<>();
//         buildGraph(root, null, graph, leafs);

//         int count = 0;

//         for (TreeNode leaf : leafs) {
//             Queue<TreeNode> q = new LinkedList<>();
//             Set<TreeNode> visited = new HashSet<>();
//             q.add(leaf);
//             visited.add(leaf);
//             int d = distance;

//             while (d-- >= 0) {
//                 int size = q.size();

//                 while (size-- > 0) {
//                     TreeNode curr = q.poll();
//                     if (curr != leaf && leafs.contains(curr))
//                         count++;

//                     for (TreeNode u : graph.getOrDefault(curr, new ArrayList<>())) {
//                         if (!visited.contains(u)) {
//                             q.add(u);
//                             visited.add(u);
//                         }
//                     }
//                 }
//             }
//         }
//         return count / 2;
//     }

//     private void buildGraph(TreeNode root, TreeNode parent, HashMap<TreeNode, List<TreeNode>> graph,
//             Set<TreeNode> leafs) {

//         if (root == null)
//             return;

//         if (root.left == null && root.right == null)
//             leafs.add(root);

//         if (parent != null) {
//             graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(root);
//             graph.computeIfAbsent(root, k -> new ArrayList<>()).add(parent);

//         }

//         buildGraph(root.left, root, graph, leafs);
//         buildGraph(root.right, root, graph, leafs);

//     }
// }

class Solution {
    public int countPairs(TreeNode root, int distance) {
        int count[] = new int[1];
        solve(root, distance, count);
        return count[0];
    }

    private List<Integer> solve(TreeNode root, int distance, int[] count) {
        if (root == null)
            return Collections.singletonList(0);

        if (root.left == null && root.right == null)
            return Collections.singletonList(1);

        List<Integer> left = solve(root.left, distance, count);
        List<Integer> right = solve(root.right, distance, count);

        for (int l : left)
            for (int r : right)
                if (l != 0 && r != 0 && l + r <= distance)
                    count[0]++;

        List<Integer> totalLeafs = new ArrayList<>();

        for (int i : left)
            if (i != 0)
                totalLeafs.add(i + 1);

        for (int i : right)
            if (i != 0)
                totalLeafs.add(i + 1);

        return totalLeafs;

    }
}