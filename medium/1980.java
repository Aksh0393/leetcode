class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < nums.length; i++)
            str.append(nums[i].charAt(i) == '0' ? 1 : 0);

        return str.toString();
    }
}