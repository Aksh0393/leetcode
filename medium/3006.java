import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        int n = s.length();
        List<Integer> i_indices = KMP_OP(s, a);
        List<Integer> j_indices = KMP_OP(s, b);
        List<Integer> ans = new ArrayList<>();

        for (int i : i_indices) {
            int leftLimit = Math.max(0, i - k);
            int rightLimit = Math.min(n - 1, i + k);

            int lowerBound = lowerBound(j_indices, leftLimit);

            if (lowerBound != -1 && j_indices.get(lowerBound) <= rightLimit)
                ans.add(i);

        }

        return ans;

    }

    private int[] computeLPS(String s) {
        int n = s.length();
        int lps[] = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        char a[] = s.toCharArray();
        while (i < n) {
            if (a[i] == a[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private List<Integer> KMP_OP(String txt, String pat) {

        int m = txt.length();
        int n = pat.length();
        int i = 0; // txt
        int j = 0; // pat
        int lps[] = computeLPS(pat);
        List<Integer> indices = new ArrayList<>();
        while (i < m) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                indices.add(i - j); // abcd abc
                j = lps[j - 1];
            } else if (i < m && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return indices;
    }

    private int lowerBound(List<Integer> list, int target) {
        int res = -1;
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return res;
    }
}