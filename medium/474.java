class Solution {
    int [] even;
    int [] odd;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        even = new int[len]; // for even freq
        odd = new int[len]; // for odd freq

        int [][][] dp = new int[len][m+1][n+1]; 
        for(int i = 0 ;i<len ; i++){
            String s = strs[i];
            int l = s.length();
            int count = 0;
            for(char x : s.toCharArray()){
                if(x == '0')count++;
            }
            even[i] = count; // store 0 freq
            odd[i] = l - count; // store 1 freq
        }
        return helper(0 , m , n , dp); // call our dp function
    }

    public int helper(int ind ,  int m , int n , int[][][] dp ){
        if(ind >= odd.length)return 0;

        int x = m - even[ind]; // remaning even 
        int y = n - odd[ind]; // remaning odd
        if(dp[ind][m][n] != 0)return dp[ind][m][n];
        int pick = Integer.MIN_VALUE;

        if(x >=0 && y >= 0 ){
            pick = 1 + helper(ind + 1 , x , y , dp); // pass new  :- even odd remaning
         }

        int nonPick = helper(ind + 1 ,  m , n , dp); // pass old odd even

        return dp[ind][m][n] = Math.max(pick , nonPick);
    }
}