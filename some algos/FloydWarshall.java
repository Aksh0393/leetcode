class FloydWarshall {
    public void floydWarshall(int[][] dist, int V) {
        // dist[i][j] = shortest distance from i to j

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != (int) 1e9 && dist[k][j] != (int) 1e9 && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
