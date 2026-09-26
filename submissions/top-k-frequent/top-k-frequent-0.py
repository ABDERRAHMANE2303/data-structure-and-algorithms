class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        occurs = {}
        out = []
        for i in range(len(nums)) :
            occurs[nums[i]] = occurs.get(nums[i],0) + 1
        for i in range (k) : 
            higher = max(occurs, key=occurs.get)
            out.append(higher)
            del occurs[higher]
        return out 
        