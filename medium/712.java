import java.util.Arrays;

class Solution {
    int dp[][],m,n;
   char a[],b[];
    public int minimumDeleteSum(String s1, String s2) 
    {
        this.a=s1.toCharArray();
        this.b=s2.toCharArray();
        this.m=s1.length();
        this.n=s2.length();
        dp=new int[this.m][this.n];
        for(int i[]:dp)
        Arrays.fill(i,-1);
        return sol(0,0);
    }
    
    public int sol(int i,int j)
    {
        if(i>=m ||j>=n)
        {
            if(i>=m && j>=n)return 0;
            return i==m?deadend(b,j,n):deadend(a,i,m);
        }
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(a[i]==b[j])
            return sol(i+1,j+1);
        
        return dp[i][j]=Math.min(sol(i+1,j)+(int)a[i], sol(i,j+1)+(int)b[j]);
        
    }
    public int deadend(char c[],int i,int k)
    {
        int sum=0;
        for(int j=i;j<k;j++)
            sum+=(int)c[j];
        return sum;
    }
}