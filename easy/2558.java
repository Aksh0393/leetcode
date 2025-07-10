import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0L;
        for (int i : gifts) {
            q.add(i);
            sum += i;
        }

        while (k-- > 0) {
            int num = q.poll();
            int sqroot = (int) Math.floor(Math.sqrt(num));
            q.add(sqroot);
            int remainingNum = num - sqroot;
            sum -= remainingNum;
        }

        return sum;
    }
}