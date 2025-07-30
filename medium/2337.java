class Solution {
    public boolean canChange(String start, String target) {

        char a[] = start.toCharArray();
        char b[] = target.toCharArray();
        int n = a.length;
        int i = 0;
        int j = 0;

        while (i < n || j < n) {

            while (i < n && a[i] == '_')
                i++;

            while (j < n && b[j] == '_')
                j++;

            if (i == n || j == n)
                return i == n && j == n;

            if (a[i] != b[j])
                return false;

            if (a[i] == 'L' && i < j)
                return false;

            if (a[i] == 'R' && i > j)
                return false;

            i++;
            j++;

        }
        return true;
    }
}