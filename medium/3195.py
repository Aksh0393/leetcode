class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        minRow = len(grid)
        maxRow = -1
        maxCol = -1
        minCol = len(grid[0])

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    minRow = min(minRow, i)
                    maxRow = max(maxRow, i)
                    minCol = min(minCol, j)
                    maxCol = max(maxCol, j)

        return (maxRow - minRow + 1)*(maxCol - minCol+1)
