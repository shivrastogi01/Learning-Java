class MaximumSwap {
    public int maximumSwap(int num) {
        char[] str = String.valueOf(num).toCharArray();
        int[][] dp =new int[str.length][2];
        dp[str.length-1][0]= -1;
        dp[str.length-1][1]= -1;
        
        for(int iIndex = str.length-2; iIndex >= 0; iIndex--) {
            if(Integer.valueOf(str[iIndex+1]) > dp[iIndex+1][0]) {
                dp[iIndex][0] = Integer.valueOf(str[iIndex+1]);
                dp[iIndex][1] = iIndex+1;
            }
            else {
                dp[iIndex][0] = dp[iIndex+1][0];
                dp[iIndex][1] = dp[iIndex+1][1];
            }
        }
        
        for(int iIndex = 0; iIndex < str.length; iIndex++) {
            if(Integer.valueOf(str[iIndex]) < dp[iIndex][0] ) {
                char temp = str[dp[iIndex][1]];
                str[dp[iIndex][1]] = str[iIndex];
                str[iIndex] = temp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(str));
    }
}