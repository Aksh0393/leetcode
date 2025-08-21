class Solution:
    def countSquares(self, grid: List[List[int]]) -> int:
        return self.dp(grid)
        # m, n = len(grid), len(grid[0])
        # t = [[-1]*n for _ in range(m)]
        # result = 0
        # for i in range(m):
        #     for j in range(n):
        #         result += self.solve(i, j, grid, t, m, n)

        # return result

    def solve(self, i, j, grid, t, m, n) -> int:
        if i >= m or j >= n:
            return 0

        if grid[i][j] == 0:
            return 0

        if t[i][j] != -1:
            return t[i][j]

        right = self.solve(i, j+1, grid, t, m, n)
        down = self.solve(i+1, j, grid, t, m, n)
        diagonal = self.solve(i+1, j+1, grid, t, m, n)

        t[i][j] = 1 + min(right, down, diagonal)
        return t[i][j]

    def dp(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        t = [[0]*(n+1) for _ in range(m+1)]
        result = 0

        for i in range(m):
            for j in range(n):
                if i>=m or j>=n:
                    continue
                if grid[i][j] == 0:
                    continue
                t[i+1][j+1] = 1 + min(t[i][j+1], t[i+1][j], t[i][j])
                result += t[i+1][j+1]

        return result
