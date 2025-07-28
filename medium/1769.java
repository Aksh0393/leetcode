// class Solution {
//     public int[] minOperations(String boxes) {
//         int n = boxes.length();
//         char a[] = boxes.toCharArray();
//         int ans[] = new int[n];

//         for (int i = 0; i < n; i++)
//             if (a[i] == '1')
//                 for (int j = 0; j < n; j++)
//                     ans[i] += Math.abs(j - i);

//         return ans;

//     }
// }

class Solution {
    public int[] minOperations(String boxes) {
        char a[] = boxes.toCharArray();
        int n = a.length;
        int[] res = new int[n];
        int leftMoves = 0, leftBalls = 0;
        int rightMoves = 0, rightBalls = 0;
        // 001011
        // Left to right

        for (int i = 0; i < n; i++) {

            res[i] += leftMoves;
            res[n-1-i] += rightMoves;

            leftBalls+=a[i]=='1'?1:0;
            leftMoves+=leftBalls;

            rightBalls+=a[n-1-i]=='1'?1:0;
            rightMoves+=rightBalls;
        }

        return res;
    }
}
