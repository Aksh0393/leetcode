class Solution {
    public int numberOfBeams(String[] banks) {

        int prevCount = 0;
        int totalBeams = 0;

        for (String bank : banks) {
            int currCount = 0;
            for (char c : bank.toCharArray())
                if (c == '1')
                    currCount++;

            totalBeams += (prevCount * currCount);

            prevCount = currCount == 0 ? prevCount : currCount;

        }

        return totalBeams;
    }
}