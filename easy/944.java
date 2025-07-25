class Solution {
    public boolean detectCapitalUse(String word) {

        int capital = 0;

        for (char c : word.toCharArray())
            if (Character.isUpperCase(c))
                capital++;

        if (capital == 0 || capital == word.length())
            return true;

        if (capital == 1 && Character.isUpperCase(word.charAt(0)))
            return true;

        return false;

    }
}