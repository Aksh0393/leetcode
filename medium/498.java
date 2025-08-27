// import java.util.*;

// class Solution {
//     public int[] findDiagonalOrder(int[][] mat) {

//         HashMap<Integer, List<Integer>> map = new HashMap<>();

//         for (int i = 0; i < mat.length; i++)
//             for (int j = 0; j < mat[0].length; j++)
//                 map.computeIfAbsent(i + j, k -> new ArrayList<>()).add(mat[i][j]);

//         List<Integer> resultList = new ArrayList<>();
//         boolean flip = true;
//         for (int k = 0; k <= mat.length + mat[0].length - 2; k++) {
//             List<Integer> diagonal = map.get(k);
//             if (diagonal == null)
//                 continue;
//             if (flip)
//                 Collections.reverse(diagonal);
//             resultList.addAll(diagonal);
//             flip = !flip;
//         }
//         int[] result = new int[resultList.size()];
//         for (int i = 0; i < resultList.size(); i++)
//             result[i] = resultList.get(i);

//         return result;
//     }
// }

// // 0 1 2
// // 3 4 5
// // 6 7 8

// // 0 -> 0
// // 1 -> 1 3
// // 2 -> 2 4 6
// // 3 -> 5 7
// // 4 -> 8

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0];

        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0, dir = 1;
        int idx = 0;

        while (idx < m * n) {
            result[idx++] = mat[row][col];

            if (dir == 1) { // moving up-right
                if (col == n - 1) { // hit right boundary
                    row++;
                    dir = -1;
                } else if (row == 0) { // hit top boundary
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            } else { // down
                if (row == m - 1) {
                    col++;
                    dir = 1;
                } else if (col == 0) {
                   row++;
                   dir = 1;
                }
                else{
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}