class Solution {
    public int minimumTimeToInitialState(String s, int k) {

        int count = 1;
        int i = k;
        int n = s.length();

        while (i < n) {
            if (check(s, i, n))
                break;

            i += k;
            count++;
        }
        return count;

    }

    private boolean check(String s, int i, int n) {

        return s.substring(i, n).equals(s.substring(0, n - i));
    }

}