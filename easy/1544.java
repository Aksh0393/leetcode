class Solution {
    public String makeGood(String s) {

        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (str.length() > 0
                    && (ch - 32 == str.charAt(str.length() - 1) || ch + 32 == str.charAt(str.length() - 1)))
                str.deleteCharAt(str.length() - 1);
            else
                str.append(ch);
        }

        return str.toString();
    }
}