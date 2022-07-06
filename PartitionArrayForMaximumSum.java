
   class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return f(0, k, n, arr, dp);
        
        //TABULATION
        
        for(int i = n - 1; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            int maxElem = Integer.MIN_VALUE;
            for(int ind = i; ind - i  + 1 <= k && ind < n; ind++){
                maxElem = Math.max(maxElem, arr[ind]);
                int sum = maxElem * (ind - i + 1);
                max = Math.max(max, sum + dp[ind + 1]);
            }
        
            dp[i] = max;
        }
        
        return dp[0];
    }
}