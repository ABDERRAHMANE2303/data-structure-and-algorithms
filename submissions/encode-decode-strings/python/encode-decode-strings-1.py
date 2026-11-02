class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for string in strs :
            encoded_str += str(len(string)) + "#" +string 
        return encoded_str

    def decode(self, s: str) -> List[str]:
        strs = []
        current_string = ""

        while s : 
            j = s.index("#")
            string_length = int(s[:j])
            start_index = j+1

            current_string = s[start_index:start_index + string_length]
            strs.append(current_string)
            s= s[start_index + string_length:] 
         
        return strs
