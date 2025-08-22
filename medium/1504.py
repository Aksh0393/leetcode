class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        m = len(mat)
        n = len(mat[0])
        res = 0

        for startRow in range(m):
            mask = [1] * n
            for endRow in range(startRow, m):
                for col in range(n):
                    mask[col] = mask[col] & mat[endRow][col]

                res += self.countOnesSubArray(mask)

        return res

    def countOnesSubArray(self, arr) -> int:
        count = 0
        curr = 0
        for num in arr:
            if num == 1:
                curr += 1
            else:
                curr = 0

            count += curr

        return count
