class Solution {
    public int countPermutations(int[] comp) {

        long ans = 1;
        for (int i = 1; i < comp.length; i++) {
            if (comp[i] <= comp[0])
                return 0;
            ans *= i;
            ans %= (long) (1e9 + 7);
        }
        return (int) ans;
    }
}