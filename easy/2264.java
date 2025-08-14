class Solution {
    public String largestGoodInteger(String num) {

        char a[] = num.toCharArray();
        int n = a.length;
        char ans = ' ';
        for (int i = 1; i < n - 1; i++) {
            if (a[i] == a[i - 1] && a[i] == a[i + 1])
                ans = (char) Math.max(ans, a[i]);
        }

        if (ans == ' ')
            return String.valueOf("");
        return String.valueOf(ans).repeat(3);
    }
}