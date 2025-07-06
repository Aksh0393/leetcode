// import java.util.Arrays;

// class Solution {
//     public int[] countOfPairs(int n, int x, int y) {

//         int graph[][] = new int[n][n];
//         for (int i[] : graph)
//             Arrays.fill(i, 10000);

//         for (int i = 0; i < n; i++) {
//             graph[i][i] = 0;
//         }
//         for (int i = 0; i < n - 1; i++) {
//             graph[i][i + 1] = 1;
//             graph[i + 1][i] = 1;
//         }

//         graph[x - 1][y - 1] = 1;
//         graph[y - 1][x - 1] = 1;

//         for (int via = 0; via < n; via++)
//             for (int i = 0; i < n; i++)
//                 for (int j = 0; j < n; j++)
//                     graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);

//         int result[] = new int[n];

//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 if (i != j)
//                     result[graph[i][j] - 1]++;

//         return result;

//     }
// }

class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];

        // Iterate over all pairs of houses:
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // Calculate the minimum distance using a different approaches
                int val = Math.min(
                        Math.abs(i - j), // Direct distance between houses i and j, i->j
                        Math.min(
                                Math.abs(i - x) + 1 + Math.abs(y - j), // Distance through x and y, i->x->y->j
                                Math.abs(i - y) + 1 + Math.abs(x - j) // Distance through y and x, i->y->x->j
                        ));
                // Update the result array based on the minimum distance
                result[val - 1] += 2; // from i to j and j to i
            }
        }
        return result;
    }
}