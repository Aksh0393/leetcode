# from collections import defaultdict


# class Solution:
#     def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
#         diag = defaultdict(list)

#         for i in range(len(mat)):
#             for j in range(len(mat[0])):
#                 diag[i+j].append(mat[i][j])

#         result = []
#         flip = True
#         for i in range(len(mat) + len(mat[0]) - 1):
#             diagonal = diag.get(i, [])
#             if flip:
#                 diagonal.reverse()

#             result.extend(diagonal)
#             flip = not flip

#         return result


class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        m = len(mat)
        n = len(mat[0])

        row = 0
        col = 0
        idx = 0
        result = [0] * (m * n)
        dir = 1
        while idx < m * n:
            result[idx] = mat[row][col]
            idx += 1
            if dir == 1:
                if col == n-1:
                    row += 1
                    dir = -1
                elif row == 0:
                    col += 1
                    dir = -1
                else:
                    row -= 1
                    col += 1

            elif dir == -1:
                if row == m-1:
                    col += 1
                    dir = 1

                elif col == 0:
                    row += 1
                    dir = 1

                else:
                    row += 1
                    col -= 1

        return result
