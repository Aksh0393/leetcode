import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> list = new ArrayList<>();

        int i = 0;
        int stream = 1;

        while (i < target.length && stream <= n) {

            list.add("Push");

            if (stream == target[i])
                i++;
            else
                list.add("Pop");

            stream++;

        }
        return list;
    }
}