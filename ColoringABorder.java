class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
         // 1. mark every potential candidate as -grid[row][col] and maintain coount
         // 2. if element is surrounded by 4 other same neighbours, them change it back to original
         // 3. Count the negative numbers in the grid after doing dfs, as it will help us to get the   //border elements
        dfs(grid, row, col, grid[row][col]);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public void dfs(int[][] grid, int row, int col, int color){
        grid[row][col] = -color;
        int count = 0;
        
        for(int i=0; i<4; i++){
            int r1 = row + dirs[i][0];
            int c1 = col + dirs[i][1];
            
            if(r1 < 0 || c1 < 0 || r1>=grid.length || c1>=grid[0].length || Math.abs(grid[r1][c1])!=color){
                continue;
            }
            
            count++;
            
            if(grid[r1][c1] == color){
                dfs(grid, r1, c1, color);
            }
        }
        
        if(count == 4){
            grid[row][col] = color;
        }
    }
}