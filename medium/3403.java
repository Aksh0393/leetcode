class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();

        if (numFriends == 1) {
            return word;
        }
        int index = findPivot(word);
        int length = Math.min(n - numFriends + 1, n - index);

        return word.substring(index, index + length);
    }

    private int findPivot(String word) {
        int n = word.length();
        int i = 0;
        int j = 1;
        char a[] = word.toCharArray();
        while (j < n) {
            int k = 0;

            while (j + k < n && a[i + k] == a[j + k])
                k++;

            if (j + k < n && a[j + k] > a[i + k]) {
                i = j;
                j = j + 1;
            } else
                j = j + k + 1;

        }
        return i;
    }
}