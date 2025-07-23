class Solution {
    public String addSpaces(String s, int[] spaces) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0; // s index
        int j = 0; // space index

        for (i = 0; i < n; i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            }

            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}