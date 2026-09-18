class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        out = []
        global_product = 1
        for i in range(len(nums)) :
            for j in range (len(nums)):
                if j != i :
                    global_product *= nums[j]
            out.append(global_product)
            global_product = 1
        return out