import java.util.HashMap;

class Solution {

    int n;
    int [] segMin, segMax, lazy;
    public int longestBalanced(int[] nums) {
        int res = 0;
        n = nums.length;
        segMin = new int[4 * n];
        segMax = new int[4 * n];
        lazy = new int[4 * n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum [] = new int[nums.length];
        for(int r=0;r<nums.length;r++)
        {
            int num = nums[r];  
            int val = (num & 1) == 0 ? 1 : -1;
            int prev = -1;  
            if(map.containsKey(num))
                prev = map.get(num);

            if(prev !=-1)
                // for(int i=0;i<=prev;i++)
                //     sum[i] += -val;
             updateRange(0, prev, 0, 0, n - 1, -val);

            // for(int l=0;l<=r;l++)
            //     sum[l] += val;
                updateRange(0, r, 0, 0, n - 1, val);

            // for(int l=0;l<=r;l++)
            //     if(sum[l] == 0){
            //         res = Math.max(res, r-l+1);
            //         break;
            //     }
            int l = findLeftMostZero(0, 0, n - 1);
            if (l != -1) {
                res = Math.max(res, r - l + 1);
            }
                map.put(num, r);
        }

        return res;
    }

    private void updateRange(int qs,int qe,int i,int ss,int se,int val)
    {
        propagate(i, ss, se);
        if (qs > se || qe  < ss || qe < qs)
            return;
        if (qs <= ss && qe >= se) {
            lazy[i]+=val;
            propagate(i, ss, se);
            return;
        }
        int mid = ss + (se - ss) / 2;
        updateRange(qs, qe, 2 * i + 1, ss, mid, val);
        updateRange(qs, qe, 2 * i + 2, mid + 1, se, val);
        segMin[i] = Math.min(segMin[2 * i + 1], segMin[2 * i + 2]);
        segMax[i] = Math.max(segMax[2 * i + 1], segMax[2 * i + 2]);

    }

     private void propagate(int i, int l, int r) {
        if(lazy[i]!=0){
                segMin[i] += lazy[i];
                segMax[i] += lazy[i];
                if(l!=r){
                    lazy[2*i+1] += lazy[i];
                    lazy[2*i+2] += lazy[i];
                }
                lazy[i] = 0;
        }
     }

         int findLeftMostZero(int i, int l, int r) {
        propagate(i, l, r);

        if (segMin[i] > 0 || segMax[i] < 0) return -1;

        if (l == r) return l;

        int mid = l + (r - l) / 2;
        int left = findLeftMostZero(2 * i + 1, l, mid);
        if (left != -1) return left;

        return findLeftMostZero(2 * i + 2, mid + 1, r);
    }
}