import java.util.*;;

class Solution {

    record Pair(int a, int b) {
    };
    public int longestBalanced(String s) {
        int res = 0;
        //case 1; aaaabcbc one char is same
        int count =1; 
        char a[] = s.toCharArray();
        int n = a.length;
        for(int i=1;i<n;i++)
        {
            if(a[i]==a[i-1])
                count++;
            else
            {
                res = Math.max(res,count);
                count=1;
            }
        }

        res = Math.max(res,count);

        //case 2; two char same
        res = Math.max(res, helper(a,'a','b'));
        res = Math.max(res, helper(a,'b','c'));
        res = Math.max(res, helper(a,'a','c'));

        //case 3; 3 char same
        int countA=0, countB=0, countC=0;
        Map<Pair,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            if(a[i]=='a')
                countA++;
            else if(a[i]=='b')
                countB++;
            else
                countC++;
            if(countA == countB && countA == countC)
                res = Math.max(res, countA+countB+countC);
            Pair p = new Pair(countA-countB, countA-countC);
            if(!map.containsKey(p))
                map.put(p, i);
            else
                res = Math.max(res, i - map.get(p));
        }

        return res;
    }

    private int helper(char[] a, char c, char d) {
        int n = a.length;
        int firstDiff[] = new int[2*n+1];
        Arrays.fill(firstDiff, -2);
        firstDiff[n] = -1;
        int diff = n;
        int badIndex = -1;
        int res = 0;
        // diff	- current count(x) - count(y)
        // firstDiff[diff]	- earliest index where this diff was seen
        // badIndex	- last index where an invalid character appeared
        for(int i=0;i<n;i++)
        {
            if(a[i]!=c && a[i]!=d)
            {
                badIndex = i;
                diff = n;
                firstDiff[diff] = i;
            }
            else{
                if (a[i] == c) diff++;
                else diff--;
                if(firstDiff[diff] < badIndex)
                    firstDiff[diff] = i;    
                else
                    res = Math.max(res, i - firstDiff[diff]);

            }
        }
        return res;
    }
}