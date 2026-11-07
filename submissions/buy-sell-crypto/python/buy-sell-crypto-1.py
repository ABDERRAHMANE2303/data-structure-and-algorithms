class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit,min_price = 0,prices[0]
        for i in range(1,len(prices)) :
            profit = prices[i] - min_price
            if profit>max_profit :
                max_profit= profit
            min_price = prices[i] if prices[i] < min_price else min_price
        return max_profit 


        