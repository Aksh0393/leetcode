import java.util.*;

class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int MIN = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currMin = arr[i] - arr[i - 1];
            if (MIN > currMin) {
                MIN = currMin;
                ans.clear();
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if(currMin==MIN)
                ans.add(Arrays.asList(arr[i - 1], arr[i]));

        }
        return ans;
    }
}