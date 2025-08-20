class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        st = []
        result = [0] * n

        for i in range(n-1, -1, -1):
            while st and temperatures[i] >= temperatures[st[-1]]:
                st.pop()

            if st:
                result[i] = st[-1] - i
            else:
                result[i] = 0

            st.append(i)

        return result
