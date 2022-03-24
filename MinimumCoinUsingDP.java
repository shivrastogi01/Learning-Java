	class MinimumCoinUsingDP {
	public static void main(String args []){
		int coins[]={1,3,5,7,9};
		int amount =4;
		System.out.println(coinChange(coins ,amount));
	}
    public static int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
        {
            dp[i][0]=0;
        }
        for(int i=1;i<=amount;i++)
        {
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(coins[i-1]<=j)
                {
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount]>amount ? -1:dp[coins.length][amount];
    }
}