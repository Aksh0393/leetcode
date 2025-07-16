class Solution {
    public int maximumLength(int[] nums) {

        int oddLength = 0;
        int evenLength = 0;
        int parity = -1;
        int parityLength = 0;
        for (int num : nums) {
            if (parity == -1) {
                parity = num % 2;
                parityLength = 1;
            }

            int remainder = num % 2;
            if (remainder == 0)
                evenLength++;
            else
                oddLength++;

            if (remainder == 1-parity) {
                parity = remainder;
                parityLength++;
            }

        }
        return Math.max(parityLength, Math.max(oddLength, evenLength));
    }
}