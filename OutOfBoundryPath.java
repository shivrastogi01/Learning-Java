class OutOfBoundryPath {
    Long[][][] dp;
    static final int MOD = 1000000000 + 7; 
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Long[m][n][maxMove+1];
        return (int)dfs(m,n,maxMove, startRow, startColumn);
    }
    private long dfs(int m, int n, int maxMove, int row, int col){
        if(maxMove<0)
            return 0;
        if (row < 0 || row == m || col < 0 || col == n)
            return 1;
        if (dp[row][col][maxMove]!=null)
            return dp[row][col][maxMove];
        long value = 0;
        long left = dfs(m, n, maxMove -1,row,col-1);
        long right = dfs(m, n, maxMove -1,row,col+1);
        long up = dfs(m, n, maxMove -1,row-1,col);
        long down = dfs(m, n, maxMove -1,row+1,col);
        value = (left+right+up+down)%MOD;
        dp[row][col][maxMove]= value;
        return dp[row][col][maxMove];
        
    }
}