class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=Integer.MIN_VALUE;
        int buyPrice=prices[0];

        for(int i=1;i<prices.length;i++)
        {
            maxProfit=Math.max(maxProfit,prices[i]-buyPrice);
            buyPrice=Math.min(buyPrice,prices[i]);
        }

        return maxProfit<0?0:maxProfit;
    }
}