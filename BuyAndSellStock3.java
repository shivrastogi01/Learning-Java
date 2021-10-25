class BuyAndSellStock3 {
  public int maxProfit(int[] prices) {
    int buyFirst = Integer.MIN_VALUE;  // First time buying stock
    int buySecond = Integer.MIN_VALUE; // Second time buying stock
    int sellFirst = 0;  // First time selling stock
    int sellSecond = 0; // Second time selling stock

    for (int i : prices) {
      buyFirst = Math.max(buyFirst, i * -1);
      sellFirst = Math.max(sellFirst, buyFirst + i);
      buySecond = Math.max(buySecond, sellFirst - i);
      sellSecond = Math.max(sellSecond, buySecond + i);
    }
    return sellSecond;
  }
}