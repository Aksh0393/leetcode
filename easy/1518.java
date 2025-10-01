class Solution {
    public int numWaterBottles(int b, int e) {

        int ans = b;
        int quo = ans / e;
        int rem = ans % e;
        b = rem + quo;
        ans += quo;
        while (b >= e) {
            quo = b / e;
            rem = b % e;
            b = quo  + rem;
            ans += quo;
        }

        return ans;
    }
}