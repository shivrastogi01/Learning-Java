class ArthimeticSlices {
    public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length < 3) return 0;
        int[] dp = new int[arr.length];
        int arithmeticSubarraysCount = 0;
        
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) { 
                dp[i] = dp[i - 1] + 1;
                arithmeticSubarraysCount += dp[i];
            } 
        }
        
        return arithmeticSubarraysCount;
    }
}