class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        maxD = 0
        maxA = 0

        for rect in dimensions:
            d = rect[0]**2 + rect[1]**2
            a = rect[0]*rect[1]
            if d > maxD:
                maxD = d
                maxA = a
            elif d == maxD:
                maxA = max(maxA, a)
        return maxA