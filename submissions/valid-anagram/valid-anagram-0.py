class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s_count = {}
        t_count = {}
        for letter in s :
            s_count[letter] = s_count.get(letter,0) + 1
        for letter in t :
            t_count[letter] = t_count.get(letter,0) + 1
        
        if s_count == t_count :
            return True
        return False

        