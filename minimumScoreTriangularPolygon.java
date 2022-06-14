class minimumScoreTriangularPolygon {
    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        int[][] dp = new int[len][len];
        for(int gap = 2;gap<len;gap++){
            
            for(int i=0,j=gap;j<len;i++,j++){
                if(gap==2) dp[i][j] = values[i]*values[i+1]*values[i+2];
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k=i+1;k<j;k++){
                        int base = values[i]*values[j]*values[k];
                        int above = dp[i][k];
                        int down = dp[k][j];
                        int total = base+above+down;
                        if(total<min) min = total;
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len-1];
    }
}