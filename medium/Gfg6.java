class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Gfg6 {
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int minDiff(Node root, int K) {
        int a[] = new int[1];
        a[0] = Integer.MAX_VALUE;
        solve(root, K, a);
        return a[0];

    }

    private static void solve(Node root, int k, int[] a) {
        if (root == null)
            return;

        if (k == root.data) {
            a[0] = 0;
            return;
        }

        if (k > root.data) {
            a[0] = Math.min(a[0], k - root.data);
            solve(root.right, k, a);
        } else {
            a[0] = Math.min(a[0], root.data - k);
            solve(root.left, k, a);
        }

    }
}