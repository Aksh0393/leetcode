class Solution {
    public boolean canReorderDoubled(int[] arr) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int x:arr){
            if(x < min) min = x;
            if(x > max) max = x;
        }

        int N = (Math.max(Math.abs(min), Math.abs(max)) + 1) * 2;
        int[] count = new int[2 * N];

        for(int x: arr)
            count[N + x]++;

        if(min >= 0){
            for(int x = min; x <= max; ++x){
                if(count[N + 2 * x] < count[N + x])
                    return false;
                count[N + 2 * x] -= count[N + x];
            }
        }else{

            for(int x = 0; x <= max; ++x){
                if(count[N + 2 * x] < count[N + x])
                    return false;
                count[N + 2 * x] -= count[N + x];
            }

            for(int x = -1; x >= min; --x){
                if(count[N + 2 * x] < count[N + x])
                    return false;
                count[N + 2 * x] -= count[N + x];
            }
        }
        return true;
    }
}