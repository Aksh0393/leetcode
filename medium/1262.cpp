class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int inf = 1e5, mod1f = inf, mod1s = inf, mod2f = inf, mod2s = inf, sum = 0;
        // mod1f = smallest value with mod 1 
        // mod1s = second smallest value with mod1
        for(int i=0; i<nums.size(); ++i) {
            sum += nums[i];
            if(nums[i] % 3 == 1) {
                if(mod1f == inf)
                    mod1f = nums[i];
                else if(mod1s == inf) {
                    mod1s = nums[i];
                    if(mod1f > mod1s) swap(mod1f, mod1s);
                } else if(mod1f > nums[i]) {
                    mod1s = mod1f;
                    mod1f = nums[i];
                } else if(mod1s > nums[i]) {
                    mod1s = nums[i];
                }
            }
            if(nums[i] % 3 == 2) {
                if(mod2f == inf)
                    mod2f = nums[i];
                else if(mod2s == inf) {
                    mod2s = nums[i];
                    if(mod2f > mod2s) swap(mod2f, mod2s);
                } else if(mod2f > nums[i]) {
                    mod2s = mod2f;
                    mod2f = nums[i];
                } else if(mod2s > nums[i]) {
                    mod2s = nums[i];
                }
            }
        }
        if(sum % 3 == 1)
            return sum - min(mod1f, mod2f + mod2s);
        if(sum % 3 == 2)
            return sum - min(mod2f, mod1f + mod1s);
        return sum;
    }
};