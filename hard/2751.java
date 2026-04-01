import java.util.*;

class Solution {
    static class Pair {
        int index;
        int position;
        int direction;
        int health;

        Pair(int i, int p, int d, int h) {
            this.index = i;
            this.position = p;
            this.direction = d;
            this.health = h;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        ArrayList<Pair> list = new ArrayList<>();
        ArrayList<Pair> myStack = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            list.add(new Pair(i, positions[i], directions.charAt(i), healths[i]));
        }

        Collections.sort(list, (a, b) -> a.position - b.position);

        for (Pair p : list) {
            if (p.direction == 'R') {
                myStack.add(p);
                continue;
            }

            while (myStack.isEmpty() == false && myStack.get(myStack.size() - 1).direction == 'R' && p.health > 0) {
                if (myStack.get(myStack.size() - 1).health > p.health) {
                    myStack.get(myStack.size() - 1).health = myStack.get(myStack.size() - 1).health - 1;
                    p.health = 0;
                } else if (myStack.get(myStack.size() - 1).health < p.health) {
                    myStack.remove(myStack.size() - 1);
                    p.health = p.health - 1;
                } else {
                    myStack.remove(myStack.size() - 1);
                    p.health = 0;
                }
            }
            if (p.health > 0)
                myStack.add(p);
        }

        Collections.sort(myStack, (a,b) ->a.index - b.index );

        for(Pair p:myStack)
        ans.add(p.health);

        return ans;

    }
}