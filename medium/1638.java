import java.util.Arrays;

class Solution {
    private String s, t;
    private int m, n;
    private int[][] memoLeft;
    private int[][] memoRight;

    public int countSubstrings(String s, String t) {
        m = s.length();
        n = t.length();
        this.s = s;
        this.t = t;
        memoLeft = new int[m + 1][n + 1];
        memoRight = new int[m + 1][n + 1];
        int count = 0;
        Arrays.stream(memoLeft).forEach(a -> Arrays.fill(a, -1));
        Arrays.stream(memoRight).forEach(a -> Arrays.fill(a, -1));

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (s.charAt(i) != t.charAt(j)) {
                    int left = countLeft(i - 1, j - 1);
                    int right = countRight(i + 1, j + 1);
                    count += (left + 1) * (right + 1);
                }

        return count;
    }

    private int countRight(int i, int j) {

        if (i >= m || j >= n)
            return 0;
        if (memoRight[i][j] != -1)
            return memoRight[i][j];

        if (s.charAt(i) == t.charAt(j))
            memoRight[i][j] = 1 + countRight(i + 1, j + 1);

        else
            memoRight[i][j] = 0;
        return memoRight[i][j];
    }

    private int countLeft(int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (memoLeft[i][j] != -1)
            return memoLeft[i][j];
        if (s.charAt(i) == t.charAt(j))
            memoLeft[i][j] = 1 + countLeft(i - 1, j - 1);
        else
            memoLeft[i][j] = 0;
        return memoLeft[i][j];
    }
}