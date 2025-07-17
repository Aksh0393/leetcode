import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1)
            return Collections.singletonList(0);

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int indegree[] = new int[n];
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            indegree[v]++;
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);

        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 1)
                q.add(i);

        int remainingNodes = n;

        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            while (size-- > 0) {
                int u = q.poll();
                for (int v : graph.getOrDefault(u, new ArrayList<>())) {
                    indegree[v]--;
                    if (indegree[v] == 1)
                        q.add(v);
                }
            }
        }

        return new ArrayList<>(q);

    }
}