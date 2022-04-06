class CherryPicker {
    
    int dp[][][][];
    
    public int cherryPickup(int[][] grid) { 
        dp = new int[grid.length][grid[0].length][grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=0;k<grid.length;k++){
                    for(int l=0;l<grid[0].length;l++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        
        int ans = solve(0,0,0,0,grid);
        
        return ans < 0 ? 0 : ans;
    }
    
    public int solve(int r1, int c1, int r2, int c2, int grid[][]){
        if(r1>=grid.length || c1>=grid[0].length || r2>=grid.length || c2>=grid[0].length || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        
        if(r1==grid.length-1 && c1==grid[0].length-1){
            return grid[r1][c1];
        }
        
        if(dp[r1][c1][r2][c2]!=-1){
            return dp[r1][c1][r2][c2];
        }
        
        int cherries = 0;
        
        if(r2==r1 && c2==c1){
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        
        int f1 = solve(r1+1, c1, r2+1, c2, grid);
        int f2 = solve(r1+1, c1, r2, c2+1, grid);
        int f3 = solve(r1, c1+1, r2+1, c2, grid);
        int f4 = solve(r1, c1+1, r2, c2+1, grid);
        
        cherries += Math.max(f1, Math.max(f2, Math.max(f3,f4)));
        
        return dp[r1][c1][r2][c2] = cherries;
    }
    
}