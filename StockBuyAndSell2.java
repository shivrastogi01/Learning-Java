class StockBuyAndSell2 { //Buy and sell imediately not take more than one day
    public int maxProfit(int[] prices) {
        int profit=0,buy=prices[0];
        for(int i = 0;i<prices.length;i++){
            if(prices[i]>=buy){
                profit+=prices[i]-buy;
            }
            buy=prices[i];
        }
        return profit;
    }
}