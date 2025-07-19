import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {

    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    static ArrayList<Integer> topView(Node root) {

        TreeMap<Integer, Integer> map = new TreeMap<>(); // axis, val

        if (root == null)
            return new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            Node currNode = curr.node;
            int currLevel = curr.level;
            if (!map.containsKey(currLevel))
                map.put(currLevel, currNode.data);

            if (currNode.left != null)
                q.add(new Pair(currNode.left, currLevel - 1));
            if (currNode.right != null)
                q.add(new Pair(currNode.right, currLevel + 1));

        }

        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            list.add(entry.getValue());

        return list;

    }
}