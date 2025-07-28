class Solution {
    // public int minChanges(String s) {

    //     char a[] = s.toCharArray();
    //     int c = 0;

    //     for (int i = 0; i < a.length - 1; i += 2)
    //         if (a[i] != a[i + 1])
    //             c++;

    //     return c;

    // }

    public int minChanges(String s) {
        int changes = 0;
        for (int i = 0; i < s.length(); i += 2)
            changes += s.charAt(i) ^ s.charAt(i + 1);


        return changes;
    }
}