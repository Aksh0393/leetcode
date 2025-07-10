import java.util.PriorityQueue;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] - b[0] != 0)
                return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }

        while (k-- > 0) {
            int[] temp = heap.poll();
            int idx = temp[1];
            int number = temp[0];

            nums[idx] = number * multiplier;
            heap.offer(new int[] { nums[idx], idx });
        }

        return nums;
    }
}
