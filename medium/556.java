class Solution {
    public int nextGreaterElement(int n) {

        char a[] = String.valueOf(n).toCharArray();

        n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) // 1397652
            i--;

        if (i < 0)
            return -1;

        int j = n - 1;
        while (j > i && a[j] <= a[i])
            j--;

        swap(i, j, a);
        reverse(i + 1, n - 1, a);

        if (Long.parseLong(String.valueOf(a)) > Integer.MAX_VALUE)
            return -1;
        return Integer.parseInt(String.valueOf(a));

    }

    private void swap(int i, int j, char a[]) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(int i, int j, char a[]) {
        while (i < j)
            swap(i++, j--, a);
    }
}