class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long count =0;
        long zero=0;
        for(int i:nums)
        {
            if(i == 0)
            zero++;
            else
            zero=0;

            count+=zero;

        }
        return count;
    }
}
