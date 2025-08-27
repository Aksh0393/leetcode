import java.util.HashMap;
import java.util.Stack;
import java.util.function.BiFunction;

class Solution {
    public int evalRPN(String[] tokens) {

        HashMap<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a,b)-> a+b);
        map.put("-", (a,b)-> a-b);
        map.put("*", (a,b)-> a*b);
        map.put("/", (a,b)-> a/b);

        Stack<Integer> st = new Stack<>();
        for (String i:tokens)
        {
            if (map.containsKey(i))
            {
                int b = st.pop();
                int a= st.pop();
                st.push(map.get(i).apply(a, b));
            }
            else
            st.push(Integer.parseInt(i));
        }

        return st.pop();
    }
}