import java.util.*;

// class Solution {
//     public int[] deckRevealedIncreasing(int[] deck) {

//         int n = deck.length;
//         int result[] = new int[n];
//         Arrays.sort(deck);

//         int i = 0; // deck index
//         int j = 0; // result index
//         boolean skip = false;
//         while (i < n) {

//             if (result[j] == 0) {
//                 if (!skip) {
//                     result[j] = deck[i];
//                     i++;
//                 }
//                 skip = !skip;
//             }
//             j = (j + 1) % n;
//         }

//         return result;

//     }
// }

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int result[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(deck);
        for (int i = 0; i < n; i++)
            q.add(i);

        for (int i = 0; i < n; i++) {
            int idx = q.poll();
            result[idx] = deck[i];
            if (!q.isEmpty())
                q.add(q.poll());
        }

        return result;
    }
}