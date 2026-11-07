class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left,right = 0,len(prices)
        max_profit,curr_profit =0 ,0
        while left < right-1 :
            current = prices[left]
            left +=1
            potential_profit = max(prices[left:right+1]) - current
            if potential_profit > 0 :
                max_profit = max (max_profit,potential_profit)
        return max_profit 

        
        