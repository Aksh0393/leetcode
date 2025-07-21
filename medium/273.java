class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String[] belowTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen" };
        String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        return solve(num, belowTwenty, tens).toString();
    }

    private String solve(int num, String[] belowTwenty, String[] tens) {
        StringBuilder s = new StringBuilder();
        if (num < 20)
            s.append(belowTwenty[num]);
        else if (num < 100)
            s.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        else if (num < 1000)
            s.append(solve(num / 100, belowTwenty, tens)).append(" Hundred ")
                    .append(solve(num % 100, belowTwenty, tens));
        else if (num < 1_000_000)
            s.append(solve(num / 1000, belowTwenty, tens)).append(" Thousand ")
                    .append(solve(num % 1000, belowTwenty, tens));
        else if (num < 1_000_000_000)
            s.append(solve(num / 1_000_000, belowTwenty, tens)).append(" Million ")
                    .append(solve(num % 1_000_000, belowTwenty, tens));
        else
            s.append(solve(num / 1_000_000_000, belowTwenty, tens)).append(" Billion ")
                    .append(solve(num % 1_000_000_000, belowTwenty, tens));
        return s.toString().trim();

    }
}