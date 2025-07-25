class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {

        String newStart = String.valueOf(start - 1);
        String newFinish = String.valueOf(finish);
        return solve(newFinish, limit, s) - solve(newStart, limit, s);
    }

    private long solve(String s, int limit, String suffix) {

        if (s.length() < suffix.length())
            return 0;
        long count = 0;
        int n = s.length();

        // 12678
        // 34
        // 5-2 =3
        int remainingLength = n - suffix.length();
        String sSuffix = s.substring(n - suffix.length());

        for (int i = 0; i < remainingLength; i++) {
            int currDigit = s.charAt(i) - '0';
            if (currDigit <= limit)
                count += currDigit * Math.pow(limit + 1, remainingLength - i - 1);
            else
               return count += Math.pow(limit + 1, remainingLength - i);

        }

        if (sSuffix.compareTo(suffix) >= 0)
            count++;

        return count;
    }
}