// https://www.geeksforgeeks.org/problems/euler-circuit-and-path/1
import java.util.List;

class Gfg3 {
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        if (!isConnected(V, adj))
            return 0;

        int oddCount = 0;

        for (List<Integer> a : adj) {
            if (a.size() % 2 != 0)
                oddCount++;
        }

        // If count is more than 2, then graph is not Eulerian
        if (oddCount > 2) {
            return 0; // Non-Eulerian
        }

        if (oddCount == 2)
            return 1; // Semi-Eulerian (It has only Euler Path)

        return 2; // Euler Circuit

    }

    private boolean isConnected(int v, List<Integer>[] adj) {
        boolean vis[] = new boolean[v];
        int index = -1;

        for (int i = 0; i < adj.length; i++) {
            List<Integer> a = adj[i];
            if (a.size() > 0) {
                index = i;
                break;
            }
        }

        dfs(index, adj, vis);

        for (int i = 0; i < v; i++)
            if (!vis[i] && adj[i].size() > 0)
                return false;

        return true;
    }

    private void dfs(int src, List<Integer>[] adj, boolean[] vis) {

        vis[src] = true;
        for (int v : adj[src]) {
            if (!vis[v])
                dfs(v, adj, vis);
        }
    }
}