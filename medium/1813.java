import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {

        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        List<String> list1 = List.of(s1.split("\\s+"));
        List<String> list2 = List.of(s2.split("\\s+"));

        int i = 0, m = list1.size();
        int j = 0, n = list2.size();

        while (i < m && j < n && list1.get(i).equals(list2.get(j))) {
            i++;
            j++;
        }

        int m1 = list1.size() - 1;
        int n1 = list2.size() - 1;
        while (n1 >= j && m1 >= i && list2.get(n1).equals(list1.get(m1))) {
            m1--;
            n1--;
        }

        return n1 < j;

    }
}