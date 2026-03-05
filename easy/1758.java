class Solution {
    public int minOperations(String s) {

        int startWithZero = 0; // 010101
        int startWithOne = 0; // 101010
        int n = s.length();
        char[] a = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (a[i] == '0')
                    startWithOne++;
                else
                    startWithZero++;
            }
            else
            {
                if(a[i] == '1')
                startWithOne++;
                else
                startWithZero++;
            }
        }
        return Math.min(startWithZero, startWithOne);
    }
}