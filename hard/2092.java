import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int m[] : meetings) {
            int u = m[0];
            int v = m[1];
            int t = m[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] { t, v });
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] { t, u });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.add(new int[] { 0, 0 });
        pq.add(new int[] { firstPerson, 0 });
        boolean vis[] = new boolean[n];
        while (!pq.isEmpty()) {
            int a[] = pq.poll();
            int person = a[0];
            int time = a[1];
            if (vis[person])
                continue;
            vis[person] = true;
            for (int v[] : graph.getOrDefault(person, new ArrayList<>())) {
                int nextPerson = v[1];
                int nextPersonTime = v[0];
                if (!vis[nextPerson] && nextPersonTime >= time) {
                    pq.add(new int[] { nextPerson, nextPersonTime });
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (vis[i])
                ans.add(i);

        return ans;
    }
}
