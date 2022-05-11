class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==0){
                flipRow(grid,i);
            }
        }
        int res=0;
        for(int col=n-1;col>=0;col--){
            int sum=0;
            for(int row=0;row<m;row++){
                sum+=grid[row][col];
            }
            if(sum<=m/2){
                sum=m-sum;
            }
            res+=sum<<(n-1-col);
        }
        return res;
    }
    
    private void flipRow(int[][] grid,int row){
        for(int i=0;i<grid[row].length;i++){
            grid[row][i]=1-grid[row][i];
        }
    }
}