class Solution {
    public int maxArea(int[] a) {
        int s=0;
        int e=a.length-1;
        int ans=0;
        while(s<e)
        {
            ans=Math.max(ans,Math.min(a[s],a[e])*(e-s));
            if(a[s]<a[e]) s++;
            else if(a[s]>a[e])e--;
            else{s++;e--;}
        }
       return ans;
    }
}








































   // int low = 0;
   //      int high = height.length-1;
   //      int max= 0;
   //      while(low < high) {
   //          max = Math.max(Math.min(height[low],height[high]) * (high-low),max);
   //          if(height[low]<height[high]){
   //              low++;
   //          } else {
   //              high--;
   //          }
   //      }
   //      return max;