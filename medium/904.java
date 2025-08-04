import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {

        int res = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int end = 0; end < fruits.length; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

            while (map.keySet().size() > 2) {
                int val = map.get(fruits[start]);
                val--;
                if (val == 0)
                    map.remove(fruits[start]);
                else
                    map.put(fruits[start], val);
                start++;
            }

            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}