class Solution {
    public long minTime(int[] skill, int[] mana) {
        int m = skill.length;
        int n = mana.length;
        long[] finishTime = new long[m]; // finishTime[i] = when wizard i finishes current potion

        for (int currentMana : mana) {
            finishTime[0] += skill[0] * currentMana;
            for (int i = 1; i < m; i++)
                finishTime[i] = Math.max(finishTime[i - 1], finishTime[i]) + skill[i] * currentMana;

            for (int i = m - 1; i > 0; i--)
                finishTime[i - 1] = finishTime[i] - skill[i] * currentMana;

        }

        return finishTime[m - 1];
    }
}