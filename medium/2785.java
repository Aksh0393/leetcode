import java.util.*;

class Solution {
    public String sortVowels(String s) {
        String vowelStr = "AEIOUaeiou";
        Set<Character> vowels = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : vowelStr.toCharArray())
            vowels.add(ch);

        for (char ch : s.toCharArray())
            if (vowels.contains(ch))
                map.put(ch, map.getOrDefault(ch, 0) + 1);

        char res[] = s.toCharArray();
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (vowels.contains(res[i])) {
                while (map.getOrDefault(vowelStr.charAt(j), 0) == 0)
                    j++;
                res[i] = vowelStr.charAt(j);
                map.put(vowelStr.charAt(j), map.get(vowelStr.charAt(j)) - 1);

            }
        }

        return new String(res);
    }
}