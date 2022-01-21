class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i <= grid.length-1; i++){
            for(int j = 0; j <= grid[0].length-1; j++){
                if(grid[i][j] == 1){
                    int count = 0;
                    max = Math.max(max, dfs(grid, i, j, count));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j, int count){
        if(grid[i][j] == 1){
            grid[i][j] = 2;
            count++;
            if(j >= 1) count = dfs(grid, i, j-1, count);
            if(j < grid[0].length-1) count = dfs(grid, i, j+1, count);
            if(1 <= i) count = dfs(grid, i-1, j, count);
            if(i < grid.length-1) count = dfs(grid, i+1, j, count);
        }
        return count;
    }
}