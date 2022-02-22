class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		int m=query_row,n=query_glass;
		double dp[][]=new double[101][101];
		dp[1][1]=poured;
		for(int i=1;i<100;i++){
			double sum=0;
			for(int j=1;j<=i;j++){
				if(dp[i][j]>1){
					double var=dp[i][j]-1.0;
					dp[i][j]=1;
					dp[i+1][j]+=var/2;
					dp[i+1][j+1]+=var/2;
				}
				sum+=dp[i][j];
			}
			if(sum==0)  return dp[m+1][n+1];
		}

		return dp[m+1][n+1];
	}
}