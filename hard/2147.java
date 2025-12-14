import java.util.*;

class Solution {
    public int numberOfWays(String corridor) {

        List<Integer> indicesOfSeat = new ArrayList<>();

        char a[] = corridor.toCharArray();
        for (int i = 0; i < a.length; i++)
            if (a[i] == 'S')
                indicesOfSeat.add(i);

        int n = indicesOfSeat.size();

        if (n == 0 || (n & 1) == 1)
            return 0;

        long ways = 1;
        int mod = 1_000_000_007;

        int prevEnd = indicesOfSeat.get(1);

        for (int i = 2; i < n; i += 2) {

            int currStart = indicesOfSeat.get(i);
            int length = currStart - prevEnd;
            ways = (ways * length) % mod;

            prevEnd = indicesOfSeat.get(i + 1);
        }
        return (int) ways;
    }
}