class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix,suffix = [1] * len (nums),[1] * len (nums)
        out = []
        prefix_product,suffix_product = 1,1
        for i in range (len(nums)-1) :
            prefix_product *= nums[i]
            suffix_product *= nums[-i-1]
            prefix[i+1] = prefix_product
            suffix[-i-2] = suffix_product
        for  i in range(len(nums)) :
            out.append(suffix[i] * prefix[i])
        return out