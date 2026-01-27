import java.util.*;

class Solution {
    public int maximumPopulation(int[][] logs) {
        ArrayList<int[]> events = new ArrayList<>();
        for(int log[]:logs)
        {
            events.add(new int[]{log[0],1});
            events.add(new int[]{log[1],-1});
        }

        Collections.sort(events,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        int ans =-1;
        int maxPop =-1;
        int currPop = 0;
        for(int event[]:events)
        {
            currPop+=event[1];
            if(currPop>maxPop)
            {
                maxPop=currPop;
                ans=event[0];
            }
        }




        return ans;
    }
}