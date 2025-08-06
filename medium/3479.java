class Solution {

    static class SegmentTree {

        int tree[];
        int size;

        SegmentTree(int a[]) {
            this.size = a.length;
            this.tree = new int[4 * size];

        }

        void build(int a[], int node, int l, int r) {
            if (l == r)
                tree[node] = a[l];
            else {
                int mid = l + (r - l) >> 1;
                build(a, 2 * node + 1, l, mid);
                build(a, 2 * node + 2, mid + 1, r);
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        int search(int node, int l, int r, int k) {
            if (tree[node] < k)
                return -1;

            if (l == r) {
                tree[node] = -1;
                return l;
            }

            int mid = l + (r - l) >> 1;
            int pos = -1;
            if (tree[2 * node + 1] >= k)
                pos = search(2 * node + 1, l, mid, k);
            else
                pos = search(2 * node + 2, mid + 1, r, k);

            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            return pos;
        }

    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        SegmentTree segmentTree = new SegmentTree(baskets);
        int count =0;

        for(int fruit:fruits){
            int placedIndex = segmentTree.search(0,0,segmentTree.size -1,fruit);
            if (placedIndex ==-1)
                count++;

        }

        return count;
    }
}