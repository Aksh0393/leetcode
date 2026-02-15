class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char a1[] = a.toCharArray();
        char b1[] = b.toCharArray();
        int i = a1.length - 1, j = b1.length - 1, carry = 0;
        while (i >= 0 || j >= 0)
        {
            int sum = carry;
            if (i >= 0)
                sum += a1[i--] - '0';
            if (j >= 0)
                sum += b1[j--] - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}