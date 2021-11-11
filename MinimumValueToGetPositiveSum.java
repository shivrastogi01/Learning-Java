class MinimumValueToGetPositiveSum{
    public int minStartValue(int[] nums) {
        int sum = 1;
        int start = 1;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sum < 1) {
                start += 1 - sum;
                sum = 1;
            }
        }
        
        return start;
    }
}