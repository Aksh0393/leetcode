import java.util.*;

class Solution {

    static class SegmentTree {
        int[] tree;
        int size;

        SegmentTree(int[] arr) {
            size = arr.length;
            tree = new int[4 * size];
            build(arr, 0, 0, size - 1);
        }

        private void build(int[] arr, int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = l + ((r - l) >> 1);
                build(arr, 2 * node + 1, l, mid);         // left child
                build(arr, 2 * node + 2, mid + 1, r);     // right child
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        // Find the leftmost index with capacity >= k
        int search(int node, int l, int r, int k) {
            if (tree[node] < k) return -1;
            if (l == r) {
                tree[node] = -1; // mark as used
                return l;
            }

            int mid = l + ((r - l) >> 1);
            int pos;
            if (tree[2 * node + 1] >= k) {
                pos = search(2 * node + 1, l, mid, k);
            } else {
                pos = search(2 * node + 2, mid + 1, r, k);
            }

            // Update current node after change
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            return pos;
        }
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        SegmentTree segTree = new SegmentTree(baskets);

        int unplaced = 0;
        for (int fruit : fruits) {
            int placedIndex = segTree.search(0, 0, n - 1, fruit);
            if (placedIndex == -1) {
                unplaced++;
            }
        }
        return unplaced;
    }

    public static void main(String[] args) {
        int[] fruits = {4, 2, 3};
        int[] baskets = {3, 5, 2};

        System.out.println(numOfUnplacedFruits(fruits, baskets)); // Output: 1
    }
}
