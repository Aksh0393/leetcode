import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int n = tokens.length;
        Arrays.sort(tokens);

        int currScore = 0;
        int maxScore = 0;
        int l = 0, r = n - 1;


        while (l <= r) {
            if (P >= tokens[l]) {
                currScore++;
                maxScore = Math.max(maxScore, currScore);
                P -= tokens[l];
                l++;

            } else if (currScore >= 1) {
                currScore--;
                P += tokens[r];
                r--;

            } else
                return maxScore;

        }
        return maxScore;
    }
}
