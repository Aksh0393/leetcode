import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = i;
            a[i][1] = nums1[i];
            a[i][2] = nums2[i];
        }

        Arrays.sort(a, (aa, b) -> Integer.compare(aa[1], b[1]));

        long result[] = new long[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i][1] == a[i - 1][1])
                result[a[i][0]] = result[a[i - 1][0]];
            else
                result[a[i][0]] = sum;

            pq.add(a[i][2]);
            sum += a[i][2];
            if (pq.size() > k)
                sum -= pq.poll();
        }
        return result;
    }
}