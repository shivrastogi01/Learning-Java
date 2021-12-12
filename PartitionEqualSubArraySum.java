class PartitionEqualSubArraySum {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int val : nums)
            total += val;
        if(total % 2 != 0)
            return false;
        int tar = total / 2;
        boolean[][] dp = new boolean[nums.length + 1][tar + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j >= nums[i - 1]){
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]);
                }else
                    dp[i][j] = dp[i - 1][j];
                if(j == tar && dp[i][j])
                    return true;
            }
        }
        return false;
    }   
}