class Solution {
    public int countHomogenous(String s) {
        int c = 0;
        int n = s.length();
        int count = 0;
        char a[] = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i - 1])
                c++;
            else
                c = 1;

            count = (count + c) % 1_000_000_007;
        }
        return count;
    }
}