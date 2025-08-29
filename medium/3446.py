class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
       n = len(grid)

       # bottom left - non decreasing
       for row in range(n):
           self.solve(grid,row,0,n,True)

       # top right - non increasing
       for col in range(1,n):
           self.solve(grid,0,col,n,False)

       return grid


    def solve(self, grid: List[List[int]], row: int, col: int, n: int, desc: bool) -> None:
        vals = []
        i,j=row,col

        while i<n and j<n:
            vals.append(grid[i][j])
            i+=1
            j+=1

        if desc:
            vals.sort(reverse=True)
        else:
            vals.sort()
        i,j=row,col

        for val in vals:
            grid[i][j]=val
            i+=1
            j+=1


