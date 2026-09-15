class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        occurs={}
        if len(nums)==0:
            return False
        for i in nums : 
            if i in occurs and occurs.get(i,0)>1 :
                return True
            occurs[i] = occurs.get(i,0) + 1
        if occurs.get(nums[len(nums)-1],0)>1:
            return True
        return False