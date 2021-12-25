class LargestSumOfAverages {
    double[][] dp;
    int k;
    int[] a;
    long[] prefSum;
    int n;
    double dfs(int i, int p)
    {
        if(i==n)
        {
            return 0;
        }
        if(p==k)
        {
            return -10000;
        }
        if(dp[i][p]==0)
        {
            for(int j=i+1; j<=n; j++)
            {
                double avg=prefSum[j]-prefSum[i];
                avg/=j-i;
                dp[i][p]=Math.max(dp[i][p], avg+dfs(j, p+1));
            }   
        }
        return dp[i][p];
    }
    public double largestSumOfAverages(int[] nums, int k) {
        n=nums.length;
        dp=new double[n][k];
        this.k=k;
        a=nums;
        prefSum=new long[n+1];
        for(int i=1; i<=n; i++)
        {
            prefSum[i]=prefSum[i-1]+a[i-1];
        }
        double ans=0;
        ans=dfs(0, 0);
        return ans;
    }
}