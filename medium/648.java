import java.util.*;

class Solution {
    TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        StringTokenizer tokenizer = new StringTokenizer(sentence);
        StringJoiner result = new StringJoiner(" ");

        for (String word : dictionary)
            insert(word);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            String replacement = search(word);
            result.add(replacement);
        }
        return result.toString();
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    private String search(String word) {
        {
            TrieNode node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null)
                    return word;
                node = node.children[index];
                if (node.isEnd)
                    return word.substring(0, i + 1);
            }
            return word;
        }
    }
}

class TrieNode {

    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}