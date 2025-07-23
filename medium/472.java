import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        HashSet<String> wordSet = new HashSet<>();
        HashMap<String, Boolean> memo = new HashMap<>();
        for (String word : words)
            wordSet.add(word);

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (canForm(word, wordSet, memo)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean canForm(String word, HashSet<String> wordSet, HashMap<String, Boolean> memo) {
        if (memo.containsKey(word))
            return memo.get(word);

        int n = word.length();
        for (int i = 1; i < n; i++) {
            String prefix = word.substring(0, i);
            if (wordSet.contains(prefix)) {
                String suffix = word.substring(i);
                if (wordSet.contains(suffix) || canForm(suffix, wordSet, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }
        memo.put(word, false);
        return false;
    }
}