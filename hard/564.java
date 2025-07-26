import java.util.ArrayList;
import java.util.List;

class Solution {
    public String nearestPalindromic(String s) {

        int n = s.length();
        int firstHalfLength = (n + 1) / 2;
        long val = Long.parseLong(s.substring(0, firstHalfLength));
        List<Long> possibleResults = new ArrayList<>();

        possibleResults.add(halfToPalindrome(val, n));
        possibleResults.add(halfToPalindrome(val - 1, n));
        possibleResults.add(halfToPalindrome(val + 1, n));

        possibleResults.add((long) Math.pow(10, n - 1) - 1);
        possibleResults.add((long) Math.pow(10, n) + 1);
        System.out.println(possibleResults);
        long ans = 0;
        long minDiff = Long.MAX_VALUE;
        val = Long.parseLong(s);
        for (long i : possibleResults) {
            if (i == val)
                continue;
            long diff = Math.abs(i - val);

            if (diff < minDiff) {
                minDiff = diff;
                ans = i;
            } else if (diff == minDiff) {
                ans = Math.min(ans, i);
            }
        }
        return String.valueOf(ans);

    }

    private Long halfToPalindrome(long half, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(half);
        StringBuilder rev = new StringBuilder().append(half).reverse();

        if (n % 2 == 0) {
            sb.append(rev);
        } else {
            sb.append(rev.substring(1));
        }

        return Long.parseLong(sb.toString());

    }
}