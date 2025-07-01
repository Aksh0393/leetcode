 class Solution {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    void backtrack(int n, int index, boolean[] visited) {
        if (index > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                backtrack(n, index + 1, visited);
                visited[i] = false;
            }
        }
    }
}
