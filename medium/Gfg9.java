import java.util.*;

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        if (k > q.size())
            return q;
        Vector<Integer> v = new Vector<>();

        int remaining = q.size() - k;

        while (!q.isEmpty() && k-- > 0)
            v.add(q.poll());

        Collections.reverse(v);
        q.addAll(v);
        while (remaining-- > 0)
            q.add(q.poll());

        return q;

    }
}