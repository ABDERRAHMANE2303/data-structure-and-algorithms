class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price  = prices[0];
        for (int i =1; i<prices.length ;i++){
            int profit = prices[i] - min_price;
            if (profit > max_profit) max_profit = profit;
            min_price = Math.min(prices[i],min_price);
        }
        return max_profit;
    }
}        