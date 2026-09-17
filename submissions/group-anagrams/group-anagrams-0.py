class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        occurs =[{} for i in range (len(strs))]
        groups = {}
        out = []

        for i,string in enumerate(strs) :
            string_occurs = occurs[i]
            for char in string : 
                string_occurs[char] = string_occurs.get(char,0) + 1
        
        for i,occur in enumerate(occurs) : 
            signature = tuple(sorted(occur.items()))
            groups.setdefault(signature, []).append(strs[i])
        
        for group in groups.values() : 
            out.append(group)

        return out