import java.util.Stack;

class Solution {
    public int maxWidthRamp(int[] nums) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums.length; i++)
            if (st.isEmpty() || nums[st.peek()] >= nums[i])
                st.push(i);

        int res = 0;
        for (int i = nums.length-1; i >= 0; i--)
            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                res = Math.max(res, i - st.pop());

        return res;
    }
}