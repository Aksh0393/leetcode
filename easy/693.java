class Solution {
    public boolean hasAlternatingBits(int n) {
        int xor = n ^ (n >> 1); // XOR of n and n shifted right by 1 will give us a number that has all bits set to 1 if n has alternating bits. For example, if n is 5 (binary 101), then n >> 1 is 2 (binary 10), and n ^ (n >> 1) will be 7 (binary 111). If n is 7 (binary 111), then n >> 1 is 3 (binary 11), and n ^ (n >> 1) will be 4 (binary 100), which does not have all bits set to 1.
        return (xor & (xor + 1)) == 0; // If xor has all bits set to 1, then xor + 1 will have only one bit set to 1 (the next power of 2), and the bitwise AND of xor and xor + 1 will be 0. If xor does not have all bits set to 1, then the bitwise AND will not be 0.
    }
}