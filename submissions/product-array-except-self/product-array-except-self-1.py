class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        zeros_count =  nums.count(0)
        if zeros_count > 1 :
            return [0] * len(nums)
        
        out = [0] * len(nums)
        global_product = 1
        
        for num in nums : 
            if num !=0:
                global_product *= num
        
        for i in range (len(nums)) :
            if zeros_count == 1 :  
                if nums[i] == 0 : 
                    out[i] = global_product
                    continue
                out[i] = 0
                continue 
            out[i] = int(global_product/nums[i])

        print(global_product)
        return out