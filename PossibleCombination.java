class PossibleCombination {
    public int atMostNGivenDigitSet(String[] digits, int N) {
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;

        
        for (int i = 1; i < K; ++i)
            dp[0] += Math.pow(digits.length, i);
        
        for (int i = K-1; i >= 0; --i) {
            // compute dp[i]
            int Si = S.charAt(i) - '0';
            for (String d: digits) {
                if (Integer.valueOf(d) < Si){
                    
                    dp[i] += Math.pow(digits.length, K-i-1);
                }
                else if (Integer.valueOf(d) == Si){
                    dp[i] += dp[i+1];
                }                    
            }            
        }                
        return dp[0];
    }
}