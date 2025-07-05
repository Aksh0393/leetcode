import java.util.*;

public class Solution {
    public int countSteps(int ringIndex, int i, int n) {
        int dist = Math.abs(i - ringIndex);
        int wrapAround = n - dist;

        return Math.min(dist, wrapAround);
    }

    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        Map<Character, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = ring.charAt(i);
            graph.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0, 0 });

        boolean vis[][] = new boolean[n + 1][m + 1];

        int totalSteps = 0;
        while (!pq.isEmpty()) {
            int[] vec = pq.poll();

            totalSteps = vec[0];
            int ringIndex = vec[1];
            int keyIndex = vec[2];

            if (keyIndex == m)
                break;

            if (vis[ringIndex][keyIndex])
                continue;

            vis[ringIndex][keyIndex] = true;

            for (int nextIndex : graph.get(key.charAt(keyIndex))) {
                pq.offer(new int[] { totalSteps + countSteps(ringIndex, nextIndex, n),
                        nextIndex, keyIndex + 1 });
            }
        }

        return totalSteps + m;

    }
}