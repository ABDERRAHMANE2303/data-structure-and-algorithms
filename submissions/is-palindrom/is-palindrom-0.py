class Solution:
    def isPalindrome(self, s: str) -> bool:
        strip_s = "".join(char.lower() for char in s if char.isalnum())
        print(strip_s)
        for i in range(len(strip_s)) : 
            if strip_s[i] != strip_s[-i-1] :
                return False
        return True