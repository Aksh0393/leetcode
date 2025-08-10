import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i : asteroids) {
            boolean destroyed = false;
            while (!st.isEmpty() && i < 0 && st.peek() > 0) {
                int sum = i + st.peek();

                if (sum < 0) { // i is bigger in magnitude
                    st.pop();
                } else if (sum > 0) { // top of stack survives
                    destroyed = true;
                    break;
                } else { // equal size — both destroyed
                    st.pop();
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed)
                st.push(i);

        }

        // Convert Stack<Integer> to int[]
        int[] res = new int[st.size()];
        for (int j = 0; j < res.length; j++)
            res[j] = st.get(j);

        return res;
    }
}
