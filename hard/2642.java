import java.util.Arrays;

class Graph {

    int n;
    int[][] floyd;

    public Graph(int N, int[][] edges) {

        n = N;
        floyd = new int[n][n];
        int len = edges.length;

        for (int i = 0; i < n; i++) {
            Arrays.fill(floyd[i], (int) 1e9);
            floyd[i][i] = 0;
        }

        for (int i = 0; i < len; i++) {
            int[] a = edges[i];
            floyd[a[0]][a[1]] = a[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

    }

    public void addEdge(int[] edge) {

        int u = edge[0], v = edge[1], wei = edge[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                floyd[i][j] = Math.min(floyd[i][j], floyd[i][u] + wei + floyd[v][j]);
            }
        }

    }

    public int shortestPath(int node1, int node2) {
        return (floyd[node1][node2] == 1e9) ? -1 : floyd[node1][node2];
    }
}