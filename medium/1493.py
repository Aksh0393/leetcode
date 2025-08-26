class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        result =0
        currLen=0
        prevLen=0
        isZero=False
        for i in nums:
            if i==0:
                isZero=True
                prevLen = currLen
                currLen=0
            else:
                currLen+=1
             
            result = max(result, currLen+prevLen)
            
        if isZero:
            return result
        return result-1;        