/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray a) {
        int index = findMountainIndex(a);
        int ans = bs(a, target, 0, index);
        if (ans == -1)
            return rbs(a, target, index + 1, a.length() - 1);
        return ans;
    }

    private int findMountainIndex(MountainArray a) {
        int l = 0;
        int r = a.length() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (a.get(mid) < a.get(mid + 1))
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int bs(MountainArray a, int t, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a.get(mid) > t)
                r = mid - 1;
            else if (a.get(mid) < t)
                l = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private int rbs(MountainArray a, int t, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a.get(mid) > t)
                l = mid + 1;
            else if (a.get(mid) < t)
                r = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}