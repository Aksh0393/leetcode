class Solution {
    public String intToRoman(int num) {
        int vals[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < vals.length; i++) {
            int val = vals[i];
            while (num >= val) {
                int freq = num / val;
                ans.append(new String(symbol[i]).repeat(freq));
                num = num % val;

            }
        }

        return ans.toString();
    }
}