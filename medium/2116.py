# class Solution:
#     def canBeValid(self, s: str, locked: str) -> bool:
#         n = len(s)
#         if n % 2 != 0:
#             return False

#         openCount = 0

#         for i in range(n):
#             if s[i] == '(' or locked[i] == '0':
#                 openCount += 1
#             else:
#                 openCount -= 1

#             if openCount < 0:
#                 return False

#         closeCount = 0

#         for i in range(n-1, -1, -1):
#             if s[i] == ')' or locked[i] == '0':
#                 closeCount += 1
#             else:
#                 closeCount -= 1

#             if closeCount < 0:
#                 return False

#         return True


class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)
        if n % 2 != 0:
            return False

        openStack = []
        openCloseStack = []

        for i in range(n):
            if locked[i] == '0':
                openCloseStack.append(i)
            elif s[i] == '(':
                openStack.append(i)
            elif s[i] == ')':
                if openStack:
                    openStack.pop()
                elif openCloseStack:
                    openCloseStack.pop()
                else:
                    return False

        while openStack and openCloseStack and openStack[-1] < openCloseStack[-1]:
            openCloseStack.pop()
            openStack.pop()

        return not openStack
