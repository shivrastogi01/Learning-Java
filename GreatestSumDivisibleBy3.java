class GreatestSumDivisibleBy3{
    public int maxSumDivThree(int[] nums) {
        int dp[][]=new int[nums.length][3];
        for(int temp[]:dp)
            Arrays.fill(temp,-1);
        return rec(0,nums.length,nums,0,dp);
    }
    int rec(int curr,int len,int nums[],int rem,int[][] dp) {
        if(curr==len) {
            if(rem!=0)
                return Integer.MIN_VALUE;
            return 0;
        }
        if(dp[curr][rem]!=-1)
            return dp[curr][rem];
        int max=Math.max(nums[curr]+rec(curr+1,len,nums,(rem+nums[curr])%3,dp),
                        rec(curr+1,len,nums,rem,dp));
        return dp[curr][rem]=max;
    }
}