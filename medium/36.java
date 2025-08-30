class Solution {
    public boolean isValidSudoku(char[][] a) {
        int r = a.length;
        int c = a[0].length;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (a[i][j] == '.')
                    continue;

                else if (cr(a, i, j) == false)
                    return false;
            }
        return true;

    }

    public boolean cr(char[][] a, int r, int c) {
        char val = a[r][c];
        int gg = r, op = c;
        for (int i = c + 1; i < a[0].length; i++)
            if (a[r][i] == val)
                return false;

        for (int j = r + 1; j < a.length; j++)
            if (a[j][c] == val)
                return false;

        c = (c / 3) * 3;
        r = (r / 3) * 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++) {
                if (i == gg && j == op)
                    continue;
                if (a[i][j] == val)
                    return false;
            }
        return true;

    }
}