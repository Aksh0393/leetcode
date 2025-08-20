class Solution:
    def decodeString(self, s: str) -> str:
        st = []
        for ch in s:
            if ch != ']':
                st.append(ch)
                continue

            temp = ""
            while st and st[-1] != '[':
                temp = st.pop() + temp

            if st and st[-1] == '[':
                st.pop()

            num = ""
            while st and st[-1].isdigit():
                num = st.pop() + num

            add = temp * int(num)
            st.append(add)

        return "".join(st)
