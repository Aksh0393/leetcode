class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}

// class Solution {
//     public int rangeBitwiseAnd(int left, int right) {
//         int cnt = 0;
//         while (left != right) {
//             left >>= 1;
//             right >>= 1;
//             cnt++;
//         }
//         return (left << cnt);
//     }
// }
