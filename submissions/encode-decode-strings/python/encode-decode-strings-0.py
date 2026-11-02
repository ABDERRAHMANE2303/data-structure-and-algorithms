class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for string in strs :
            encoded_str +=  string + "é"
        return encoded_str

    def decode(self, s: str) -> List[str]:
        strs = []
        current_string = ""
        for char in s : 
            if char == "é" : 
                strs.append(current_string)
                current_string = ""
                continue
            current_string += char
        return strs 


