class Solution {

    public static int numRescueBoats(int[] people, int limit) {
        int[] arr = new int[limit+1];
        for (int w : people) {
            arr[w]++;
        }

        int boats = 0;
        int i = 1, j = limit;
        while (i <= j) {
            if (arr[i] <= 0) i++;
            else if (arr[j] <= 0) j--;
            else if (i+j <= limit) {
                arr[i]--;
                arr[j]--;
                boats++;
            } else {
                arr[j]--;
                boats++;
            }
        }

        return boats;
    }
}