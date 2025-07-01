import java.util.*;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int needed = 1 << k; // Total number of codes = 2^k
        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (!seen.contains(sub)) {
                seen.add(sub);
                needed--;
                if (needed == 0)
                    return true; // All codes found early
            }
        }

        return false;
    }
}
