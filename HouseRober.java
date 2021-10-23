class HouseRober {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);
       
        for (int i = 2; i < n; i++) {
            int value1 = dp[i-2];
            int value2 = i-3 < 0 ? 0 : dp[i-3];
            dp[i] = nums[i] + Math.max(value1, value2);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}