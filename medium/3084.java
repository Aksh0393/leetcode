class Solution {
    public long countSubstrings(String s, char c) {
        long substrings =0;
        long count =0;

        for(char i:s.toCharArray())
        {
            if(i == c)
            {
                substrings+=count+1;
                count++;
            }
        }
        return substrings;
    }
}